package de.teamLocster.controller;
import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.core.errors.UserNotFoundException;
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


/**
 * @author Jakob Gensel
 * @version 1.0
 */
@Controller
public class ProfilepageController {

    UserService userService;

    UserRepository userRepository;  // das ist nicht ganz richtig...

    @Autowired
    ProfilepageController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Calls the profilepage with the users information
     * @param id id of the shown user
     * @return ResponseEntity.ok
     * @throws UserNotFoundException Exception with not found id
     */
    @GetMapping(path = "/{id}")
    ResponseEntity<User> findById(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return ResponseEntity.ok(this.userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("No Persons found for id " + id)));
    }

    /**
     * Calls your profilepage if you are logged in
     * @param authentication user must be logged in
     * @param model
     * @return profile page with your data
     */
    @GetMapping("/profilepage")
    public ModelAndView profilePage (Authentication authentication, Model model) {
        model.addAttribute("title", "Your Profile");
        String userEmail = authentication.getName();
        try
        {
            User user = userService.getUserByEmailAddress(userEmail);
            model.addAttribute("loggedInUser", user);

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

    /**
     * Calls function in {@link UserService} to delete the user with the given id
     * @param id id of to be deleted user
     */
    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Long id) {
        this.userRepository.deleteById(id);
    }


}
