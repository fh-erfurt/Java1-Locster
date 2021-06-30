package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImpressumConteoller {
    @GetMapping("/impressum")
    public String getImpressum() {
        return "impressum";
    }
}

