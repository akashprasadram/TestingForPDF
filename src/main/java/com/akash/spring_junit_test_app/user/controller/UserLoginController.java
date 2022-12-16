package com.akash.spring_junit_test_app.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.akash.spring_junit_test_app.user.ExpHandeller.InternalServerError;
import com.akash.spring_junit_test_app.user.dto.LoginUser;
import com.akash.spring_junit_test_app.user.dto.RegisterUser;
import com.akash.spring_junit_test_app.user.services.RegisterUserService;
import com.akash.spring_junit_test_app.user.services.UserServiceImpl;
import com.akash.spring_junit_test_app.user.services.UserServices;

@Controller
public class UserLoginController {

    @Autowired
    private RegisterUserService service;



    @RequestMapping("/")
    public String showHome() {
        return "index";
    }

    @RequestMapping("/showLogin")
    public String showLogin(Model model) {
        model.addAttribute("user",new LoginUser());
        return "signin";
    }

    @PostMapping("/signin")
    public String loginController(@ModelAttribute("user") LoginUser user, Model model) {
        System.out.println(user);
        RegisterUser user1=service.getUserByEmail(user.getUsername());
        if(user1==null)
        {
            model.addAttribute("errormsg", "User is not present!!! Kindly Signup first....");
            model.addAttribute("user", user);
            return "signin";
        }
        else if(!user.getPassword().equals(user1.getPassword()))
        {
            model.addAttribute("errormsg", "Invalid Password!!!");
            model.addAttribute("user", user);
            return "signin";
        }
        model.addAttribute("username",user1.getFirstName()+" "+user1.getLastName());
        return "showUser";
    }

    @RequestMapping("/showSignup")
    public String showSignup(Model model) {
        model.addAttribute("user", new RegisterUser());
        return "RegisterUser";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signupController(@ModelAttribute("user") RegisterUser user, Model model) {
        System.out.println(user);
        RegisterUser user1 = service.addUser(user);
        if (user1 == null) {
            model.addAttribute("user", user);
            model.addAttribute("errormsg", "Unable to save user internal server error!!!");
            return "RegisterUser";
        }
        model.addAttribute("username",user1.getFirstName()+" "+user1.getLastName());
        return "showUser";
    }
}
