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
public class FriendlistController {
    /**
     * Calls the friendlist page
     * @param model
     * @return view
     */
    @GetMapping("/friendlist")
    public ModelAndView profilePage (Model model)
    {
        model.addAttribute("title", "Locter.de.Friendlist");
        return new ModelAndView("friendlist");
    }
}