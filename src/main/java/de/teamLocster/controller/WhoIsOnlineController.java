package de.teamLocster.controller;

import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Molham Al-khodari
 * @version 1.0
 */
@Controller
public class WhoIsOnlineController {

    @Autowired
    private UserService userService;

    /**
     * Calls the whoisonline page
     *
     * @param model
     * @return view
     */
    @GetMapping("/whoisonline")
    public ModelAndView getWhoisonline(Model model) {
        model.addAttribute("title", "Locster.de.Who_Is_Online");
        model.addAttribute("users", userService.whoIsOnline());
        return new ModelAndView("whoisonline");
    }
}
