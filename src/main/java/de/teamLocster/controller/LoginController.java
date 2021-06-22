package de.teamLocster.controller;

import de.teamLocster.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    //to get login form page
    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String getLoginForm() {
        //return html page name
        return "login";
    }

    //checking for login credentials
    @RequestMapping(value ="/login", method=RequestMethod.POST )
    public String login(@ModelAttribute (name="User") User user, Model model) {

        user.setEMailAddress("admin@gmail.com");
        user.setPasswordHash("admin");

        String email = user.getEMailAddress();
        String password = user.getPasswordHash();

        if("admin@gmail.com".equals(email) && "admin".equals(password)) {
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

    }
}
