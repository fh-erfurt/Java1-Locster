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
public class Error404Controller {

    @GetMapping("/error404")
    public ModelAndView getError404(Model model) {
        model.addAttribute("title", "Locster.de.Error404");
        return new ModelAndView("404");
    }
}
