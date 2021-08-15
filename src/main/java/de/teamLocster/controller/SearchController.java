package de.teamLocster.controller;

import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Matthias Gabel
 * @version 1.0
 */
@Controller
public class  SearchController {
    @Autowired
    private UserService userService;

    /**
     * Calls function in {@link UserService} to search for the given characters
     * @param model
     * @param query to be searched characters
     * @return view with search results
     */
    @GetMapping("/search")
    public ModelAndView getSearch(Model model
            , @RequestParam(value = "q", required = false) String query
    ) {
        model.addAttribute("title", "Locster.de.Search");
        model.addAttribute("users", userService.search(query));
        return new ModelAndView("search");
    }
}
