/*
===================================
Matthias Gabel
===================================
*/
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;


public class UserContainerTest {

    // Given
    UserContainer testUserContainer = new UserContainer();

    @Test
    public void should_register_max_mustermann()
    {
        // Given
        String firstName    = "Max";
        String lastName     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann@fh-email.de";
        String password     = "password123";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.sex sex = PersonalInfo.sex.male;
        // When
        testUserContainer.registerUser(firstName, lastName, username, email, password, birthdate, sex);

        // Then
        assertEquals("MaMus257",                            testUserContainer.getUsers().get(0).getAccountDetails().getUsername());
        assertEquals("Max",                                 testUserContainer.getUsers().get(0).getPersonalInfo().getFirstName());
        assertEquals("Mustermann",                          testUserContainer.getUsers().get(0).getPersonalInfo().getLastName());
        assertEquals("max.mustermann@fh-email.de",          testUserContainer.getUsers().get(0).getAccountDetails().getMailAddress());
        assertEquals("password123",                         testUserContainer.getUsers().get(0).getAccountDetails().getPassword());
        assertEquals(new Date(1999, Calendar.JUNE,22),    testUserContainer.getUsers().get(0).getPersonalInfo().getBirthdate());
        assertEquals(PersonalInfo.sex.male,                         testUserContainer.getUsers().get(0).getPersonalInfo().getSex());
    }
}
