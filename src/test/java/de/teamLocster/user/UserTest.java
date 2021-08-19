package de.teamLocster.user;

import static org.junit.Assert.assertEquals;

import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.*;

@SpringBootTest
public class UserTest {


    @Autowired
    UserService userService;

    @Autowired
    UserRepository repository;

    @BeforeEach
    public void beforeEach() {

    }

    @AfterEach
    public void afterEach() {
        // repository.deleteAll();
    }

    @Test
    void save() {
        // GIVEN
        User given = new User();

        // WHEN
        Long result = repository.save(given).getId();

        // THEN
        Assertions.assertThat(result)
                .isNotNull()
                .isGreaterThan(0);
    }

    @Test
    void findAll() {
        // GIVEN
        User given1 = new User();
        User given2 = new User();

        List<Long> idsOfPersisted = new ArrayList<>();
        idsOfPersisted.add(repository.save(given1).getId());
        idsOfPersisted.add(repository.save(given2).getId());

        // WHEN
        List<User> result = repository.findAll();

        // WHEN
        Assertions.assertThat(result).isNotNull().isNotEmpty().allMatch(Objects::nonNull);
        Assertions.assertThat(idsOfPersisted).isNotNull().isNotEmpty().allMatch(Objects::nonNull);
    }

    @Test
    void findById() {
        String firstName = "Monika";
        String lastName = "Muster";

        RelationshipStatus rs = RelationshipStatus.SINGLE;

        LocalDate birthDay = LocalDate.ofYearDay(1990, 200);

        User testUser = new User(
                "monika@normal.de",
                "5Ül2e_L3b3Rwur5t",
                firstName,
                lastName,
                "Muster city",
                birthDay,
                "Beispiel",
                rs,
                Sex.FEMALE,
                "images/profilePic.png",
                "Ich bin die Monika",
                "Na moin ihr Gesichter!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                true
        );

        repository.save(testUser);

        User result = repository.findById(testUser.getId()).get();

        Assertions.assertThat(result.getRelationshipStatus()).isEqualTo(rs);
        assertEquals("Name of user should be equal.", firstName + lastName, result.getFirstName() + result.getLastName());
        assertEquals("Birthday of user should be equal.", birthDay, result.getBirthDay());
        assertEquals("Relationship status of user should be equal.", rs, result.getRelationshipStatus());
    }
}
