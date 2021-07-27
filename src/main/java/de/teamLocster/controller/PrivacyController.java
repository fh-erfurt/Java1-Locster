package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrivacyController {
    @GetMapping("/datenschutz")
    public ModelAndView getImpressum(Model model)
    {
        model.addAttribute("title", "Locster.de.Datenschutz");
        return new ModelAndView("privacy");
    }


}



