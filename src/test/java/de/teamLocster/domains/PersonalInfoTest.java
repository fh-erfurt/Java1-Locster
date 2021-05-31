package de.teamLocster.domains;

import de.teamLocster.user.PersonalInfoRepository;
import de.teamLocster.user.PersonalInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class PersonalInfoTest {
    PersonalInfoRepository repository;

    @BeforeEach
    public void beforeEach() {
        repository = new PersonalInfoRepository();
    }

    @AfterEach
    public void afterEach() {
        repository.deleteAll();
    }

    @Test
    void findByName() {
        // GIVEN
        PersonalInfo given1 = new PersonalInfo();
        PersonalInfo given2 = new PersonalInfo();

        given1.setFirstName("Max");
        given1.setLastName("Mustermann");
        given2.setLastName("Musterfrau");

        repository.save(given1);
        repository.save(given2);

        // WHEN
        Optional<PersonalInfo> result = repository.findBy("Mustermann");

        // WHEN
        Assertions.assertThat(result).isPresent();
        Assertions.assertThat(result.get().getFirstName()).isEqualTo("Max");
        Assertions.assertThat(result.get().getLastName()).isEqualTo("Mustermann");
    }
}
