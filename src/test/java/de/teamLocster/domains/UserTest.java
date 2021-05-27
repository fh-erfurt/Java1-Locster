package de.teamLocster.domains;

import de.teamLocster.storages.AccountDetailsRepository;
import de.teamLocster.storages.PersonalInfoRepository;
import de.teamLocster.storages.ProfileStatisticRepository;
import de.teamLocster.storages.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserTest {

    UserRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new UserRepository();
    }

    @AfterEach
    public void afterEach() {
        repository.deleteAll();
    }

    @Test
    void save() {
        // GIVEN
        User given = new User();

        // WHEN
        Long result = repository.save(given);

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
        idsOfPersisted.add(repository.save(given1));
        idsOfPersisted.add(repository.save(given2));

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

        PersonalInfo pi = new PersonalInfo(firstName, lastName, "Muster city", new Date(), "Beispiel", RelationshipStatus.SINGLE, "pseudo path", Sex.FEMALE);
        ProfileStatistic ps = new ProfileStatistic();
        AccountDetails ad = new AccountDetails("monika@normal.de", "5Ül2e_L3b3Rwur5t");

        User testUser = new User(pi, ps, ad, "Na moin ihr Gesichter!", PrivacyStatus.PUBLIC, OnlineStatus.ONLINE);

        //ad.setUser(testUser);

        Long id = repository.save(testUser);

        User result = repository.findBy(id).get();

        Assertions.assertThat(result.getPersonalInfo().getFirstName() + result.getPersonalInfo().getLastName()).isEqualTo(firstName + lastName).withFailMessage("NAMES DON'T EQUAL");
        Assertions.assertThat(result.getAccountDetails()).isEqualTo(ad).withFailMessage("ACCOUNT DETAILS DON'T EQUAL");
        Assertions.assertThat(result).isEqualTo(testUser).withFailMessage("USER DOESN'T EQUAL");
    }

}
