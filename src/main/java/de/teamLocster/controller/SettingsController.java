package de.teamLocster.controller;

import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.user.SettingsUser;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Molham Al-khodari
 * @version 1.0
 */
@Controller
public class SettingsController {

    UserService userService;
    UserRepository userRepository;

    @Autowired
    SettingsController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Calls the settings page
     * @param authentication user must be logged in
     * @param model
     * @return view
     */
    @GetMapping("/settings")
    public ModelAndView settings(Authentication authentication, Model model) {
        model.addAttribute("title", "Locster.de.Settings");
        String userEmail = authentication.getName();
        try {
            SettingsUser settingsUser = new SettingsUser(userService.getUserByEmailAddress(userEmail));
            model.addAttribute("settingsUser", settingsUser);

            return new ModelAndView("settings");
        } catch (UserNotFoundException unfE) {
            return new ModelAndView("redirect:/");
        }
    }

    /**
     * Calls function in {@link UserService} to update the profile text of user
     * @param userDto profile text
     * @param errors
     * @param redirectAttributes
     * @param authentication user must be logged in
     * @return view
     */
    @PostMapping("/settings")
    public String updateUser(@ModelAttribute @Valid SettingsUser userDto,
                             @RequestParam("profilePicture") MultipartFile multipartFile,
                             Errors errors,
                             RedirectAttributes redirectAttributes,
                             Authentication authentication)
    {
        if (errors.hasErrors()) {
            return "settings";
        }
        else
        {
            String oldEmail = authentication.getName();
            try
            {
                userService.updateUser(oldEmail, userDto, multipartFile);
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

    /**
     * Calls function in {@link UserService} to delete the user
     * @param user
     * @param redirectAttributes
     * @param authentication
     * @return
     * @throws UserNotFoundException
     */
    @PostMapping("delete")
    public String deleteUser(@ModelAttribute User user,
                                   RedirectAttributes redirectAttributes,
                                   Authentication authentication) throws UserNotFoundException {

            String email = authentication.getName();
            try
            {
                userService.deleteUser(email);
                return "redirect:/login";
            }
            catch (UserNotFoundException e1)
            {
                redirectAttributes.addFlashAttribute("message", "USER NOT FOUND");
                return "redirect:/";
            }

    }
}


