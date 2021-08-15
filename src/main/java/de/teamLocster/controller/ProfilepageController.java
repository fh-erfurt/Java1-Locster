package de.teamLocster.controller;

import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.guestbook.GuestbookEntryService;
import de.teamLocster.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class ProfilepageController {

    @Autowired
    UserService userService;

    @Autowired
    GuestbookEntryService guestbookEntryService;

    @GetMapping("/profilepage")
    public ModelAndView getMyProfilePage(Authentication authentication, Model model) {
        model.addAttribute("title", "Mein Profil");
        try {
            User user = userService.getUserByEmailAddress(authentication.getName());
            model.addAttribute("profileUser", user);
            model.addAttribute("myProfile", true);
            model.addAttribute("guestbookEntries", guestbookEntryService.getReceivedGuestbookEntriesOfUser(user));

            return new ModelAndView("profilepage");
        }
        catch (UserNotFoundException unfE) {
            return new ModelAndView("redirect:/error/404");
        }
    }

    @GetMapping("/profilepage/{id}")
    public ModelAndView getProfilePage(@PathVariable(value = "id") Long id, Model model) {
        try {
            User user = userService.getUserById(id);
            model.addAttribute("title", String.format("Profil von %s %s", user.getFirstName(), user.getLastName()));
            model.addAttribute("profileUser", user);
            model.addAttribute("myProfile", false);
            model.addAttribute("guestbookEntries", guestbookEntryService.getReceivedGuestbookEntriesOfUser(user));

            return new ModelAndView("profilepage");
        }
        catch (UserNotFoundException unfE) {
            return new ModelAndView("redirect:/error/404");
        }
    }

    @PostMapping("/profilepage")
    public String updateUser(@ModelAttribute @Valid ProfileTextUser userDto,
                             Errors errors,
                             RedirectAttributes redirectAttributes,
                             Authentication authentication)
    {
        if (errors.hasErrors()) {
            return "profilepage";
        }
        else
        {
            String oldEmail = authentication.getName();
            try
            {
                userService.updateProfileText(oldEmail, userDto);
                return "redirect:/profilepage";
            }
            catch (UserNotFoundException e1)
            {
                redirectAttributes.addFlashAttribute("message", "USER NOT FOUND"); // TODO
                return "redirect:/";
            }
            catch (UserAlreadyExistException e2)
            {
                redirectAttributes.addFlashAttribute("message", "EMAIL ALREADY EXISTS");
                return "redirect:/";
            }
        }
    }
}
