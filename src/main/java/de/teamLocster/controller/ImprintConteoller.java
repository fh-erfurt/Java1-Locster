package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Molham Al-khodari
 * @version 1.0
 */
@Controller
public class ImprintConteoller {
    /**
     * Calls the imprint page
     * Imprint is a static page
     * @param model
     * @return view
     */
    @GetMapping("/impressum")
    public ModelAndView getImpressum(Model model)
    {
        model.addAttribute("title", "Locster.de.Impressum");
        return new ModelAndView("imprint");
    }
}

