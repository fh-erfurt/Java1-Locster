package de.teamLocster.user;

import de.teamLocster.core.BaseRepository;
import de.teamLocster.enums.OnlineStatus;
import de.teamLocster.enums.PrivacyStatus;
import de.teamLocster.enums.RelationshipStatus;
import de.teamLocster.enums.Sex;
import de.teamLocster.guestbook.GuestbookEntry;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class UserTest {

    // TODO: was wollen wir vom User testen?

    @Autowired
    UserService userService;

    @Autowired
    BaseRepository<User> repository;

    @BeforeEach
    public void beforeEach() {

    }

    @AfterEach
    public void afterEach() {
        repository.deleteAll(); // todo
    }

    @Test
    void save() {
        // GIVEN
        User given = new User();

        // WHEN
        Long result = userService.saveUser(given);

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

        HashSet<GuestbookEntry> book = new HashSet<>();

        Date birthDay = new Date();

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
                "pseudo path",
                "Ich bin die Monika",
                "Na moin ihr Gesichter!",
                PrivacyStatus.PUBLIC,
                OnlineStatus.ONLINE,
                book
        );

        repository.save(testUser);

        User result = repository.findById(testUser.getId()).get();

        Assertions.assertThat(result.getFirstName() + result.getLastName()).isEqualTo(firstName + lastName);
        Assertions.assertThat(result.getRelationshipStatus()).isEqualTo(rs);
        Assert.assertEquals(testUser, result);
    }
}


