package de.teamLocster.controller;

import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WhoIsOnlineController {

    @Autowired
    private UserService userService;

    @GetMapping("/whoisonline")
    public ModelAndView getWhoisonline(Model model) {
        model.addAttribute("title", "Locster.de.Who_Is_Online");
        model.addAttribute("users", userService.whoIsOnline());
        return new ModelAndView("whoisonline");
    }
}
