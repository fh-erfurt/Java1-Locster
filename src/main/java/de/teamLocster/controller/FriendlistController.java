package de.teamLocster.controller;

import de.teamLocster.actions.ActionService;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.core.errors.UsersAreNotFriendsException;
import de.teamLocster.user.User;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @version 1.0
 */
@Controller
public class FriendlistController {

    @Autowired
    ActionService actionService;

    /**
     * Calls the friendlist page
     * @param model
     * @return view
     */
    @Autowired
    UserService userService;
    @GetMapping("/friendlist")
    public ModelAndView profilePage (Model model, Authentication authentication)
    {
        try
        {
            User user = userService.getUserByEmailAddress(authentication.getName());
            model.addAttribute("title", "Meine Freunde");
            model.addAttribute("friendRequests", actionService.getReceivedFriendRequests(user));
            model.addAttribute("friends", actionService.getFriends(user));
            return new ModelAndView("friendlist");
        }
        catch (UserNotFoundException unfEx) {
            return new ModelAndView("redirect:/error/404");
        }
    }

    @PostMapping("/friendrequest/{id}")
    public ModelAndView sendFriendRequest(@PathVariable(value = "id") Long id, Authentication authentication) {
        try {
            User requestingUser = userService.getUserByEmailAddress(authentication.getName());
            if (!requestingUser.getId().equals(id)) {
                actionService.sendFriendRequest(requestingUser, userService.getUserById(id));
            }
            return new ModelAndView("redirect:/profilepage/" + id);
        }
        catch (UserNotFoundException unfEx) {
            return new ModelAndView("redirect:/error/404");
        }
    }

    @PostMapping("/removefriend/{id}")
    public ModelAndView removeFriend(@PathVariable(value = "id") Long id, Authentication authentication) {
        try {
            User requestingUser = userService.getUserByEmailAddress(authentication.getName());
            actionService.removeFriend(requestingUser, userService.getUserById(id));
            return new ModelAndView("redirect:/friendlist");
        }
        catch (UserNotFoundException | UsersAreNotFriendsException ex) {
            return new ModelAndView("redirect:/error/404");
        }
    }
}