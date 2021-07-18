package de.teamLocster.controller;

import de.teamLocster.user.LoginForm;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import de.teamLocster.util.CookieHelper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;


@Controller
public class LoginController {

    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getLoginForm(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("login");

        Cookie[] cookies = request.getCookies();

        if(CookieHelper.proveCookieExistence(cookies, "userId")) {
            mav.setViewName("/login");
            mav.addObject("error", true);
            mav.addObject("errorText", "You are already Logged in!");
            mav.addObject("loggedIn", false);
        }else{
            mav.addObject("loginForm", new LoginForm());
        }

        return mav;
    }

    // receives the Form object that was populated by the form.
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView loginSubmit(@ModelAttribute LoginForm loginForm, HttpServletResponse response) {
        //Retrieve the Data from the form
        String email = loginForm.getEmail();
        String password = loginForm.getPassword();

        ModelAndView mav = new ModelAndView("login");

        List<User> users = (List<User>) userRepository.findAll();

        AtomicBoolean foundUser = new AtomicBoolean(false);

        users.forEach(user -> {
            if(email.equals(user.getEmailAddress()) && password.equals(user.getPasswordHash()))
            {
                String userId = user.getId().toString();
                foundUser.set(true);

                Cookie cookie = new Cookie("userId", userId);
                cookie.setMaxAge(24 * 60 * 60);     //one Day

                response.addCookie(cookie);
                System.out.println("cookie Value " + cookie.getValue());
                System.out.println("cookie Domain " + cookie.getDomain());


                mav.setViewName("profilepage");
            }
        });

        if(foundUser.get() == false){
            mav.addObject("error", true);
            mav.addObject("errorMessage", "No user found with that Mail / Wrong Password");
        }


        if(mav.getViewName() == "profilepage") {
            mav.addObject("loggedIn", true);
        }
        else {
            mav.addObject("loggedIn", false);
        }
        return mav;
    }
}

