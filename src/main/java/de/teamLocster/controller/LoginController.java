package de.teamLocster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Molham Al-khodari
 * @version 1.0
 */
@Controller
public class LoginController {

    /**
     * Calls the login page
     * Login is the start page
     * You can log in or go to {@link SignupController}
     *
     * @param model
     * @return view
     */
    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getLoginForm(Model model) {
        model.addAttribute("title", "Locster.de.Login");
        return new ModelAndView("login");
    }
}
