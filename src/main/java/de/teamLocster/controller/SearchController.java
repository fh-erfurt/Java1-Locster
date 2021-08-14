package de.teamLocster.controller;

import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class  SearchController {
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ModelAndView getSearch(Model model,
                                  @RequestParam(value = "q", required = false) String query) {
        model.addAttribute("title", "Locster.de.Search");
        model.addAttribute("user", userService.search(query));
        return new ModelAndView("search");
    }
}
