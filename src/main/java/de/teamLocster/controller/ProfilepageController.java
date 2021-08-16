package de.teamLocster.controller;
import de.teamLocster.actions.ActionService;
import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.guestbook.GuestbookEntryService;
import de.teamLocster.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


/**
 * @author Jakob Gensel
 * @version 1.0
 */
@Controller
public class ProfilepageController {

    @Autowired
    UserService userService;

    @Autowired
    ActionService actionService;

    @Autowired
    GuestbookEntryService guestbookEntryService;

    /**
     * Calls your profilepage if you are logged in
     * @param authentication user must be logged in
     * @param model
     * @return profile page with your data
     */
    @GetMapping("/profilepage")
    public ModelAndView getMyProfilePage(Authentication authentication, Model model) {
        model.addAttribute("title", "Mein Profil");
        try {
            User user = userService.getUserByEmailAddress(authentication.getName());
            model.addAttribute("profileUser", user);
            model.addAttribute("myProfile", true);
            model.addAttribute("receivedGuestbookEntries", guestbookEntryService.getReceivedGuestbookEntriesOfUser(user));
            model.addAttribute("createdGuestbookEntries", guestbookEntryService.getCreatedGuestbookEntriesOfUser(user));

            return new ModelAndView("profilepage");
        }
        catch (UserNotFoundException unfE) {
            return new ModelAndView("redirect:/error/404");
        }
    }


    /**
     * Calls the profilepage with the users information
     * @param id id of the shown user
     * @return profilepage of the user
     */
    @GetMapping("/profilepage/{id}")
    public ModelAndView getProfilePage(@PathVariable(value = "id") Long id, Authentication authentication, Model model) {
        try {
            User visitingUser = userService.getUserByEmailAddress(authentication.getName());
            User visitedUser = userService.getUserById(id);
            if(visitingUser.getId().equals(id)) return new ModelAndView("redirect:/profilepage");
            model.addAttribute("title", String.format("Profil von %s %s", visitedUser.getFirstName(), visitedUser.getLastName()));
            model.addAttribute("profileUser", visitedUser);
            model.addAttribute("myProfile", false);
            model.addAttribute("isFriend", actionService.isFriend(visitingUser , visitedUser));
            model.addAttribute("openRequest", actionService.getReceivedFriendRequests(visitingUser).contains(visitedUser));
            model.addAttribute("receivedGuestbookEntries", guestbookEntryService.getReceivedGuestbookEntriesOfUser(visitedUser));

            return new ModelAndView("profilepage");
        }
        catch (UserNotFoundException unfE) {
            return new ModelAndView("redirect:/error/404");
        }
    }


    @PostMapping("/guesbookentry/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView sendPost(@PathVariable(value = "id") Long id, Authentication authentication, HttpRequest request) {
        try
        {
            User postingUser = userService.getUserByEmailAddress(authentication.getName());
            User visitedUser = userService.getUserById(id);
            String content = request.getMethodValue();

            System.out.println(content);


            /*
            userService.sendPost(userService.getUserByEmailAddress(authentication.getName()), userService.getUserById(id), content);
            */

            return new ModelAndView(String.format("redirect:/profilepage/%d", id));
        }
        catch (UserNotFoundException unfEx) {
            System.out.println(unfEx.getMessage());
            return new ModelAndView("redirect:/profilepage");
        }
    }


    /**
     * Calls function in {@link UserService} to update the profile text of user
     * @param userDto profile text
     * @param errors
     * @param redirectAttributes
     * @param authentication user must be logged in
     * @return
     */
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
