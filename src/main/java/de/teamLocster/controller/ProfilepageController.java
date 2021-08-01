package de.teamLocster.controller;

import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProfilepageController {

    UserService userService;

    UserRepository userRepository;

    @Autowired
    ProfilepageController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    ResponseEntity<User> findById(@PathVariable(value = "id") Long id) throws UserNotFoundException {
        return ResponseEntity.ok(this.userRepository
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("No Persons found for id " + id)));
    }

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

    @GetMapping("/updateUser")
    public String updateUser( Model model, RedirectAttributes redirectAttributes,Authentication authentication) {

        String userEmail = authentication.getName();
        try {
            User user = userService.getUserByEmailAddress(userEmail);
            model.addAttribute("updateUser", user);
            return "updateUser";
        } catch (UserNotFoundException e) {
            redirectAttributes.addFlashAttribute("messege", "");
            return "redirect:/profilepage";
        }
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("updateUser") User updateUser,
                           RedirectAttributes redirectAttributes,
                           Authentication authentication)
    {
        String userEmail = authentication.getName();
        try {
            User user = userService.getUserByEmailAddress(userEmail);

            user.setFirstName(updateUser.getFirstName());
            user.setLastName(updateUser.getLastName());
            user.setRegion(updateUser.getRegion());
            user.setBirthDay(updateUser.getBirthDay());
            user.setSex(updateUser.getSex());
            user.setOccupation(updateUser.getOccupation());
            user.setRelationshipStatus(updateUser.getRelationshipStatus());

            userRepository.save(user);
            return "redirect:/profilepage";
        } catch (UserNotFoundException e)
        {
            redirectAttributes.addFlashAttribute("messege","");
            return "redirect:/";
        }
    }

    @PutMapping(path = "/update/{id}", produces = "application/json")
    ResponseEntity<User> updateUser(@PathVariable Long id,@RequestBody User newUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(newUser.getFirstName());
                    user.setLastName(newUser.getLastName());
                    user.setRegion(newUser.getRegion());
                    user.setBirthDay(newUser.getBirthDay());
                    user.setSex(newUser.getSex());
                    user.setOccupation(newUser.getOccupation());
                    user.setRelationshipStatus(newUser.getRelationshipStatus());

                    return ResponseEntity.ok(this.userRepository.save(user));
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return ResponseEntity.ok(this.userRepository.save(newUser));
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteUser(@PathVariable Long id) {
        this.userRepository.deleteById(id);
    }


}
