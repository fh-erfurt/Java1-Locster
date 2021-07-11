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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public String showSignupForm (WebRequest request, Model model) {
        System.out.println("signup get loaded");
        SignupUser userDto = new SignupUser();
        model.addAttribute("user", userDto);
        return "signup";
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ModelAndView signUp(
            @ModelAttribute("user") @Valid SignupUser userDto,
            HttpServletRequest request,
            Errors errors) {

        System.out.println("signup post received");

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
