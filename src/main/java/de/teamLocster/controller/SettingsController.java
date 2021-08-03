package de.teamLocster.controller;

import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SettingsController {

    UserService userService;
    UserRepository userRepository;

    @Autowired
    SettingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/settings")
    public ModelAndView settings(Authentication authentication, Model model) {
        model.addAttribute("title", "Locster.de.Settings");
        String userEmail = authentication.getName();
        try {
            User user = userService.getUserByEmailAddress(userEmail);
            model.addAttribute("loggedInUser", user);

            return new ModelAndView("settings");
        } catch (UserNotFoundException unfE) {
            return new ModelAndView("redirect:/");
        }
    }

    @PutMapping(path = "userId")
    public void updateUserInSetting(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password) throws UserNotFoundException {
        userService.updateUserInSetting(userId, email, password);
    }

    @GetMapping("/updateUserInSetting")
    public String updateUserInSetting(Model model, RedirectAttributes redirectAttributes, Authentication authentication) {

        String userEmail = authentication.getName();
        try {
            User user = userService.getUserByEmailAddress(userEmail);
            model.addAttribute("updateUserInSetting", user);
            return "updateUserInSetting";
        } catch (UserNotFoundException unfE) {
            redirectAttributes.addFlashAttribute("messege", "");
            return "redirect:/";
        }
    }

    @PostMapping("/saveUserInSetting")
    public ModelAndView saveUserInSetting(@ModelAttribute("updateUserInSetting") User updateUser,
                                          RedirectAttributes redirectAttributes,
                                          Authentication authentication) {
        String userEmail = authentication.getName();
        try {
            User user = userService.getUserByEmailAddress(userEmail);

            user.setEmailAddress(updateUser.getEmailAddress());
            user.setPasswordHash(updateUser.getPasswordHash());

            userRepository.save(user);
            return new ModelAndView("redirect:/settings");
        } catch (UserNotFoundException unfE) {
            redirectAttributes.addFlashAttribute("messege", "");
            return new ModelAndView("redirect:/");
        }
    }

    @DeleteMapping(path = "userId")
    public void deleteUserInSetting(@PathVariable("userId") Long userId) throws UserNotFoundException {
        userService.deleteUser(userId);
    }
}
