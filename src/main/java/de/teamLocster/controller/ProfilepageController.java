package de.teamLocster.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfilepageController {
    @GetMapping("/profilepage")
    public ModelAndView profilePage (Authentication authentication, Model model) {
        model.addAttribute("title", "Your Profile");
        return new ModelAndView("profilepage");
    }
}
