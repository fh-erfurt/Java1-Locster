package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SettingsController {
    @GetMapping("/settings")
    public ModelAndView settings (Model model)
    {
        model.addAttribute("title", "Locster.de.Settings");
        return new ModelAndView("settings");
    }
}
