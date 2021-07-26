package de.teamLocster.controller;

import de.teamLocster.core.errors.UserAlreadyExistException;
import de.teamLocster.user.SignupUser;
import de.teamLocster.user.UserRepository;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Transactional
@Controller
public class SignupController {

    private final UserService userService;

    @Autowired
    public SignupController(UserRepository userRepository)
    {
        this.userService = new UserService(userRepository);
    }

    @GetMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public String showSignupForm (Model model) {
        System.out.println("signup get loaded");
        model.addAttribute("title", "newUser");
        model.addAttribute("newUser",new SignupUser());
        return "signup";
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView signUp(
            @ModelAttribute @Valid SignupUser userDto,
            Errors errors, Model model) {

        if(errors.hasErrors()) for (ObjectError e : errors.getAllErrors()) System.out.println( e.toString() + " " + e.getDefaultMessage());


        if (errors.hasErrors()) {
            System.out.println("error!");
            model.addAttribute("title", "newUser");
            model.addAttribute("errors", errors);
            model.addAttribute("newUser", new SignupUser());

            return new ModelAndView("signup");
        }


        else {
            System.out.println("signup post received");
            System.out.println(userDto.getFirstName());
            System.out.println(userDto.getLastName());
            System.out.println(userDto.getEmailAddress());


            try {
                userService.registerNewUser(userDto, errors);
            } catch (Exception uaeEx) { // TODO UserAlreadyExistException
                ModelAndView mav = new ModelAndView("signup");
                mav.addObject("message", "An account for that email address already exists.");
                System.out.println(uaeEx.getMessage());
                return mav;
            }

            String target = errors.hasErrors() ? "signup" : "login";

            return new ModelAndView(target, "user", userDto);
        }

    }
}
