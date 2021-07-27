package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {
    @GetMapping("/chat")
    public ModelAndView getChat(Model model)
    {
        model.addAttribute("title", "Locster.de.Chat");
        return new ModelAndView("chat");
    }
}
