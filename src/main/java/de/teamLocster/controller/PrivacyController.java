package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jakob Gensel
 * @version 1.0
 */
@Controller
public class PrivacyController {
    /**
     * Calls the privacy page
     * Privacy is a static page
     * @param model
     * @return view
     */
    @GetMapping("/datenschutz")
    public ModelAndView getImpressum(Model model)
    {
        model.addAttribute("title", "Locster.de.Datenschutz");
        return new ModelAndView("privacy");
    }


}



