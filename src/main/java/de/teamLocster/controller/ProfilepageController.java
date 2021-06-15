package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilepageController {
    @GetMapping("/profilepage")
    public String profilePage () {
        return "profilepage";
    }
}
