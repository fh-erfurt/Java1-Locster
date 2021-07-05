package de.teamLocster.controller;

import de.teamLocster.core.errors.UserNotFoundException;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import de.teamLocster.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Controller
public class WhoIsOnlineController {

    private final UserService userService;

    @Autowired
    public WhoIsOnlineController(UserRepository userRepository)
    {
        this.userService = new UserService(userRepository);
    }

    List<User> testUsers = Arrays.asList(
            new User(
                    "matthias.gabel@fh-erfurt.de",
                    "5Ül2e_L3b3Rwur5t",
                    "Matthias",
                    "Gabel",
                    "Muster city",
                    Timestamp.valueOf("1994-1-4 02:00:00.000000000"),
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
                    Timestamp.valueOf("1994-1-4 02:00:00.000000000"),
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
                    Timestamp.valueOf("1994-1-4 02:00:00.000000000"),
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
                    Timestamp.valueOf("1994-1-4 02:00:00.000000000"),
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
                    Timestamp.valueOf("1994-1-4 02:00:00.000000000"),
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
    String getUser(Model model) {
        model.addAttribute("user", userService.whoIsOnlinePublic());
        return ("whoisonline");
    }
}
