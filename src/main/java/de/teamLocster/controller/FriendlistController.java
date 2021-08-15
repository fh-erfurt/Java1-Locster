package de.teamLocster.controller;

import de.teamLocster.actions.ActionService;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FriendlistController {

    @Autowired
    ActionService actionService;

    @Autowired
    UserService userService;

    @GetMapping("/friendlist")
    public ModelAndView profilePage (Model model)
    {
        model.addAttribute("title", "Locter.de.Friendlist");
        return new ModelAndView("friendlist");
    }

    @PostMapping("/friendrequest/{id}")
    public ModelAndView sendFriendRequest(@PathVariable(value = "id") Long id, Authentication authentication) {
        try
        {
            actionService.sendFriendRequest(userService.getUserByEmailAddress(authentication.getName()), userService.getUserById(id));
            return new ModelAndView("redirect:/whoisonline");
        }
        catch (UserNotFoundException unfEx) {
            System.out.println(unfEx.getMessage());
            return new ModelAndView("redirect:/friendlist");
        }
    }
}