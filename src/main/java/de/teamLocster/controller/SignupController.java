package de.teamLocster.controller;

import de.teamLocster.user.User;
import de.teamLocster.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {

    private final UserService userService = new UserService();

    @GetMapping("/signup")
    public String signUp () {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(
            @RequestParam(name="firstName", required=true)String firstName,
            @RequestParam(name="lastName", required=true)String lastName,
            @RequestParam(name="birthday", required=true)String birthday,
            @RequestParam(name="gender", required=true)String gender,
            @RequestParam(name="email", required=true)String email,
            @RequestParam(name="password", required=true)String password,
            @RequestParam(name="passwordRepeat", required=true)String passwordRepeat
    ) {
        String target = "signup";
        if(password.equals(passwordRepeat))
        {
            User user = new User();
            user.setEMailAddress("blablub");
            //user.setFirstName(firstName);
            userService.saveUser(user);
            /* if (userRepository.registerNewUser()) //(firstName, lastName, birthday, gender, email, password))
            {
                target = "login";
            }*/
        }
        return "login";
    }
}
