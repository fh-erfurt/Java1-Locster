package de.teamLocster.controller;

import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProfilepageController {

    UserService userService;

    @Autowired
    ProfilepageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profilepage")
    public ModelAndView profilePage (Authentication authentication, Model model) {
        model.addAttribute("title", "Your Profile");
        String userEmail = authentication.getName();
        try
        {
            User user = userService.getUserByEmailAddress(userEmail);
            model.addAttribute("firstName", user.getFirstName());
            model.addAttribute("lastName", user.getLastName());
            model.addAttribute("city", user.getRegion());
            model.addAttribute("birthday", user.getBirthDay());
            model.addAttribute("sex", user.getSex());
            model.addAttribute("relationship", user.getRelationshipStatus());
            model.addAttribute("job", user.getOccupation());
            model.addAttribute("status", user.getProfileText());
            //ToDo: get Anzahl Besucher
            //ToDo: get letzter Besucher
            //ToDo: get neuster Freund
            //ToDo: get ältester Freund

            return new ModelAndView("profilepage");
        }
        catch (UserNotFoundException unfE) {
            return new ModelAndView("redirect:/"); //ToDo Error page!
        }
    }

}
