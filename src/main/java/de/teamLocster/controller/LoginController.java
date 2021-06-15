package de.teamLocster.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.Authenticator;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @GetMapping(value = "/loginSuccessfull")
//    public String currentUserName(Authenticaton authentication) {
//        return "redirect:/";
//    }
}
