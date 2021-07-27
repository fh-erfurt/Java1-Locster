package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendlistController {
    @GetMapping("/friendlist")
    public ModelAndView profilePage (Model model)
    {
        model.addAttribute("title", "Locter.de.Friendlist");
        return new ModelAndView("friendlist");
    }
}