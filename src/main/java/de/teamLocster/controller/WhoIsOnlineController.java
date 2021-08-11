package de.teamLocster.controller;

import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import de.teamLocster.user.User;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
public class WhoIsOnlineController {

    @Autowired
    private UserService userService;

    List<User> testUsers = Arrays.asList(
            new User(
                    "matthias.gabel@fh-erfurt.de",
                    "5Ül2e_L3b3Rwur5t",
                    "Matthias",
                    "Gabel",
                    "Muster city",
                    LocalDate.parse("1994-01-04"),
                    "Beispiel",
                    RelationshipStatus.SINGLE,
                    Sex.FEMALE,
                    "pseudo path",
                    "Ich bin die Monika",
                    "Na moin ihr Gesichter!",
                    PrivacyStatus.PUBLIC,
                    OnlineStatus.ONLINE,
                    true
            ),
            new User(
                    "molham.al.khodari@@fh-erfurt.de",
                    "5Ül2e_L3b3Rwur5t",
                    "Molham",
                    "Al-Khodari",
                    "Muster city",
                    LocalDate.parse("1994-01-04"),
                    "Beispiel",
                    RelationshipStatus.SINGLE,
                    Sex.FEMALE,
                    "pseudo path",
                    "Ich bin die Monika",
                    "Na moin ihr Gesichter!",
                    PrivacyStatus.PUBLIC,
                    OnlineStatus.ONLINE,
                    true
            ),
            new User(
                    "saskia.wohlers@fh-erfurt.de",
                    "5Ül2e_L3b3Rwur5t",
                    "Saskia",
                    "Wohlers",
                    "Muster city",
                    LocalDate.parse("1994-01-04"),
                    "Beispiel",
                    RelationshipStatus.SINGLE,
                    Sex.FEMALE,
                    "pseudo path",
                    "Ich bin die Monika",
                    "Na moin ihr Gesichter!",
                    PrivacyStatus.PUBLIC,
                    OnlineStatus.ONLINE,
                    true
            ),
            new User(
                    "dirk.hofmann@fh-erfurt.de",
                    "5Ül2e_L3b3Rwur5t",
                    "Dirk",
                    "Hofmann",
                    "Muster city",
                    LocalDate.parse("1994-01-04"),
                    "Beispiel",
                    RelationshipStatus.SINGLE,
                    Sex.FEMALE,
                    "pseudo path",
                    "Ich bin die Monika",
                    "Na moin ihr Gesichter!",
                    PrivacyStatus.PUBLIC,
                    OnlineStatus.ONLINE,
                    true
            ),
            new User(
                    "jakob.gensel@fh-erfurt.de",
                    "5Ül2e_L3b3Rwur5t",
                    "Jakob",
                    "Gensel",
                    "Muster city",
                    LocalDate.parse("1994-01-04"),
                    "Beispiel",
                    RelationshipStatus.SINGLE,
                    Sex.FEMALE,
                    "pseudo path",
                    "Ich bin die Monika",
                    "Na moin ihr Gesichter!",
                    PrivacyStatus.PUBLIC,
                    OnlineStatus.ONLINE,
                    true
            ));

    @GetMapping("/whoisonline")
    public ModelAndView getWhoisonline(Model model) {
        model.addAttribute("title", "Locster.de.Who_Is_Online");
        model.addAttribute("user", userService.whoIsOnlinePublic());
        return new ModelAndView("whoisonline");
    }
}
