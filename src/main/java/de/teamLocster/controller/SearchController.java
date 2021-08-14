package de.teamLocster.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {

    void onChange() {

    }

    @GetMapping("/search")
    public ModelAndView searchList(Model model)
    {
        model.addAttribute("title", "Locster.de.Login");
        return new ModelAndView("search");
    }

}
