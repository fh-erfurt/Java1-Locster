package de.teamLocster.controller;

import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class ProfilepageController {
    @GetMapping("/profilepage")
    public ModelAndView profilePage (Authentication authentication, Model model) {
        model.addAttribute("title", "Your Profile");
        String userEmail = authentication.getName();
        Optional<User> user = UserRepository.findByEmail(userEmail);
        if (user.isPresent()){
            model.addAttribute("firstName", user.get().getFirstName());
            model.addAttribute("lastName", user.get().getLastName());
            model.addAttribute("city", user.get().getRegion());
            model.addAttribute("birthday", user.get().getBirthDay());
            model.addAttribute("sex", user.get().getSex());
            model.addAttribute("state", user.get().getRelationshipStatus());
            model.addAttribute("city", user.get().getOccupation());
            //ToDo: get Anzahl Besucher
            //ToDo: get letzter Besucher
            //ToDo: get neuster Freund
            //ToDo: get ältester Freund

        } else {
            return new ModelAndView("redirect:/"); //ToDo Error page!
        }
        return new ModelAndView("profilepage");
    }

}
