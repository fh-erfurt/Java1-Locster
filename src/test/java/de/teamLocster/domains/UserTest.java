package de.teamLocster.domains;

import de.teamLocster.storages.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
