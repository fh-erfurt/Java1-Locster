package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ImprintConteoller {
    @GetMapping("/impressum")
    public ModelAndView getImpressum(Model model)
    {
        model.addAttribute("title", "Locster.de.Impressum");
        return new ModelAndView("imprint");
    }
}

