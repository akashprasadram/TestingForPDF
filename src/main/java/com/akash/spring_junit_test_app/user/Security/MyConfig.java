package com.akash.spring_junit_test_app.user.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService getUserDetailsService() {
        System.out.println("getUserDetailsService()");
        return new UserDetailServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        System.out.println("BCryptPasswordEncoder()");
        return new BCryptPasswordEncoder();
    }
    // Below method is to setup DaoAuthenticationProvider
    // DaoAuthenticationProvider needs a method to get user details, that will be
    // done by UserDetailsServiceImpl
    // It needs a password encoder object to handel encrypted passwords

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        System.out.println("DaoAuthenticationProvider()");
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    // configuration method
    // Below are the main config method that has to be overriden.
    // first method proved DaoAuthenticationProvider object to
    // AuthenticationManagerBuilder

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("Cofigure1()");
        auth.authenticationProvider(authenticationProvider());
    }

    // This method can define which URLs can be accesed by users having which role
    // Also which html page to use as a login form.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Cofigure2()");
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**")
                .hasRole("USER").antMatchers("/**").permitAll().and().formLogin().loginPage("/signin").and().csrf()
                .disable();
    }

}
