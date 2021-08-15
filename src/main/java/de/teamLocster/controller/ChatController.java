package de.teamLocster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jakob Gensel
 * @version 1.0
 */
@Controller
public class ChatController {
    /**
     * Calls the chat page
     * No functionalities in this cycle
     * @param model
     * @return view
     */
    @GetMapping("/chat")
    public ModelAndView getChat(Model model)
    {
        model.addAttribute("title", "Locster.de.Chat");
        return new ModelAndView("chat");
    }
}
