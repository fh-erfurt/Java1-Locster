package de.teamLocster.dummy_data;


import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import de.teamLocster.user.User;
import de.teamLocster.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class InsertDataForSimulatingAndTesting
{
    @Autowired
    UserRepository repository;

    @Test
    void createTeam() {
        LocalDate birthDay = LocalDate.ofYearDay(1990,200);

        User jakob = new User(
                "jakob@gensel.de",
                "5Ül2e_L3b3Rwur5t",
                "Jakob",
                "Gensel",
                "Marbach",
                birthDay,
                "Werkstudent",
                RelationshipStatus.ITS_COMPLICATED,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Jakob",
                "Spiderman ist nicht der einzige, der klebrige Hnde hat, wenn er im Netz war!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User dirk = new User(
                "dirk@hofmann.de",
                "5Ül2e_L3b3Rwur5t",
                "Dirk",
                "Hofmann",
                "Was weiß ich",
                birthDay,
                "Dude",
                RelationshipStatus.DIVORCED,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Dirk",
                "Na moin ihr Gesichter!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User saskia = new User(
                "saskia@wohlers.de",
                "5Ül2e_L3b3Rwur5t",
                "Saskia",
                "Wohlers",
                "Erfurt",
                birthDay,
                "Dude",
                RelationshipStatus.MARRIED,
                Sex.FEMALE,
                "pseudo path",
                "Ich bin die Saskia",
                "Ahoi!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User matze = new User(
                "matthias@gabel.de",
                "5Ül2e_L3b3Rwur5t",
                "Matthias",
                "Gabel",
                "Erfurt",
                birthDay,
                "(M)Atze",
                RelationshipStatus.IN_A_RELATIONSHIP,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Matze",
                "Was macht eigentlich dieser Knopf?",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User molham = new User(
                "molham@gabel.de",
                "5Ül2e_L3b3Rwur5t",
                "Matthias",
                "Gabel",
                "Weimar oder so",
                birthDay,
                "Softwareentwickler",
                RelationshipStatus.SINGLE,
                Sex.MALE,
                "pseudo path",
                "Ich bin der Molham",
                "Grins!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        User[] testUsers = {jakob, dirk, saskia, matze, molham};
        for(User testUser : testUsers)
        {
            repository.save(testUser);
        }
    }
}
