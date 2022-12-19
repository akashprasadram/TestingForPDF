package com.akash.spring_junit_test_app.user.controller;

import java.security.Principal;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.akash.spring_junit_test_app.user.ExpHandeller.InternalServerError;
import com.akash.spring_junit_test_app.user.dto.LoginUser;
import com.akash.spring_junit_test_app.user.dto.RegisterUser;
import com.akash.spring_junit_test_app.user.services.RegisterUserService;
import com.akash.spring_junit_test_app.user.services.RegisterUserServiceImpl;
import com.akash.spring_junit_test_app.user.services.UserServiceImpl;
import com.akash.spring_junit_test_app.user.services.UserServices;

@Controller
public class UserLoginController {

    @Autowired
    private RegisterUserService service;
    @Autowired
    private BCryptPasswordEncoder encoder;

    private static final Logger log = LoggerFactory.getLogger(UserLoginController.class.getSimpleName());

    @RequestMapping("/")
    public String showHome() {
        log.info("Inside showHome()");
        return "index";
    }

    @RequestMapping("/signin")
    public String showLogin(Model model) {
        log.info("Inside showLogin()");
        // model.addAttribute("user", new LoginUser());
        return "login";
    }

    // @PostMapping("/signin")
    // public String loginController(@ModelAttribute("user") LoginUser user, Model
    // model) {
    // log.info("Inside loginController()");
    // System.out.println(user);
    // user.setPassword(encoder.encode(user.getPassword()));
    // RegisterUser user1 = service.getUserByEmail(user.getUsername());
    // if (user1 == null) {
    // log.info("No user found");
    // model.addAttribute("errormsg", "User is not present!!! Kindly Signup
    // first....");
    // model.addAttribute("user", user);
    // return "signin";
    // } else if (!user.getPassword().equals(user1.getPassword())) {
    // log.info("Invaild password()");
    // model.addAttribute("errormsg", "Invalid Password!!!");
    // model.addAttribute("user", user);
    // return "signin";
    // }
    // model.addAttribute("username", user1.getFirstName() + " " +
    // user1.getLastName());
    // log.info("Exiting showHome()");
    // return "showUser";
    // }

    @RequestMapping("/user/home-page")
    @ResponseBody
    public String userHome(Model model, Principal principal) {
        RegisterUser user = service.getUserByEmail(principal.getName());
        return user.toString();
    }

    @RequestMapping("/showSignup")
    public String showSignup(Model model) {
        log.info("Inside showSignup()");
        model.addAttribute("user", new RegisterUser());
        return "RegisterUser";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupController(@ModelAttribute("user") RegisterUser user, Model model) {
        System.out.println(user);
        log.info("Inside signupController()");
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        RegisterUser user1 = service.addUser(user);
        if (user1 == null) {
            model.addAttribute("user", user);
            model.addAttribute("errormsg", "Unable to save user internal server error!!!");
            return "RegisterUser";
        }
        log.info("Existing signupController()");
        model.addAttribute("username", user1.getFirstName() + " " + user1.getLastName());
        return "showUser";
    }
}
