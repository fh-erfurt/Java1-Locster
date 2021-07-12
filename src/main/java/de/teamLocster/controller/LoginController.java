package de.teamLocster.controller;

import de.teamLocster.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String getLoginForm() {
        //return html page name
        return "login";
    }

    /*
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String login(
            HttpServletRequest request,
            Model model
    ) {
        String email = request.getParameter("emailAddress");
        String password = request.getParameter("password");

        boolean isAdmin ="admin@gmail.com".equals(email) && "admin".equals(password);
        boolean isRegisteredUser = false;

        if(isAdmin || isRegisteredUser) {
            // if username and password is correct, we are returning homepage
            return "profilepage";
        }
        else
        {
            // if username or password is wrong
            model.addAttribute("invalidCredentials", true);
            //returning again login page
            return "login";
        }
    } */
}
