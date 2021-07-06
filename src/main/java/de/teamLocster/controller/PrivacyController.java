package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrivacyController {
    @GetMapping("/datenschutz")
    public String getImpressum() {
        return "privacy";
    }


}



