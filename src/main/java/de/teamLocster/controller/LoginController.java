package de.teamLocster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView getLoginForm(Model model)
    {
        model.addAttribute("title", "Locster.de.Login");
        return new ModelAndView("login");
    }
}
