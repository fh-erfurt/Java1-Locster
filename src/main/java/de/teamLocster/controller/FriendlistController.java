package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FriendlistController {
    @GetMapping("/friendlist")
    public String profilePage () {
        return "friendlist";
    }
}