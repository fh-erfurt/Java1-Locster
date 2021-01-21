package de.teamLocster.User;/*
===================================
Matthias Gabel
===================================
*/
import de.teamLocster.Exceptions.EmailException;
import de.teamLocster.Exceptions.PasswordException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class UserContainerTest {

    // Given
    UserContainer testUserContainer = new UserContainer();

    @Test
    public void should_register_max_mustermann(){
        // Given
        String firstName    = "Max";
        String lastName     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann@fh-email.de";
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;
        // When
        testUserContainer.registerUser(firstName, lastName, username, email, password, birthdate, sex);


        // Then
        assertEquals("MaMus257",                            testUserContainer.getUsers().get(0).getAccountDetails().getUsername());
        assertEquals("Max",                                 testUserContainer.getUsers().get(0).getPersonalInfo().getFirstName());
        assertEquals("Mustermann",                          testUserContainer.getUsers().get(0).getPersonalInfo().getLastName());
        assertEquals("max.mustermann@fh-email.de",          testUserContainer.getUsers().get(0).getAccountDetails().getMailAddress());
        assertEquals("Password123?",                        testUserContainer.getUsers().get(0).getAccountDetails().getPassword());
        assertEquals(new Date(1999, Calendar.JUNE,22),    testUserContainer.getUsers().get(0).getPersonalInfo().getBirthdate());
        assertEquals(PersonalInfo.Sex.male,                         testUserContainer.getUsers().get(0).getPersonalInfo().getSex());
    }

    @Test
    public void should_throw_EmailException()
    {
        // Given
        String firstName    = "Max";
        String lastName     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann.fh-email.de"; // missing @
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;
        // When

        // Then
        assertThrows(EmailException.class, () -> testUserContainer.registerUser(firstName, lastName, username, email, password, birthdate, sex));
    }

    @Test
    public void should_throw_PasswordException()
    {
        // Given
        String firstName    = "Max";
        String lastName     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann@fh-email.de";
        String password     = "password";                   // missing capital, numbers, special chars
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;
        // When

        // Then
        assertThrows(PasswordException.class, () -> testUserContainer.registerUser(firstName, lastName, username, email, password, birthdate, sex));
    }

    @Test
    public void activeUser_should_contain_all_active_user()
    {
        // Given
        for (int i = 0; i < 100; i++)
        {
            switch (i)
            {
                case 5:
                case 15:
                case 30:
                case 56:
                case 78:
                case 90:
                    String firstName = "Active" + i;
                    String lastName = "de.teamLocster.User.User" + i;
                    String userName = "ActiveUser" + 1;
                    String email = "ActUser" + i + "@email.de";
                    String password = "ActiveUserPW" + i + "!";
                    Date birthday = new Date(1999, Calendar.JUNE,22);
                    PersonalInfo.Sex sex = PersonalInfo.Sex.uni;
                    testUserContainer.registerUser(firstName, lastName, userName, email, password, birthday, sex);
                    testUserContainer.getUsers().get(i).setOnlineStatus(User.OnlineStatus.online);
                    break;
                default:
                    User user = User.getNewUserForTesting();
                    testUserContainer.getUsers().add(user);
                    testUserContainer.getUsers().get(i).setOnlineStatus(User.OnlineStatus.offline);
                    break;
            }
        }

        ArrayList<User> activeUser = new ArrayList<User>();

        // When
            activeUser = testUserContainer.activeUsers();
        // Then
        assertEquals("Active5", testUserContainer.getUsers().get(5).getPersonalInfo().getFirstName());
        assertEquals("Active15", testUserContainer.getUsers().get(15).getPersonalInfo().getFirstName());
        assertEquals("Active30", testUserContainer.getUsers().get(30).getPersonalInfo().getFirstName());
        assertEquals("Active56", testUserContainer.getUsers().get(56).getPersonalInfo().getFirstName());
        assertEquals("Active78", testUserContainer.getUsers().get(78).getPersonalInfo().getFirstName());
        assertEquals("Active90", testUserContainer.getUsers().get(90).getPersonalInfo().getFirstName());
        // Final
        for (User user:
             testUserContainer.getUsers()) {
            user = null;
        }
        testUserContainer = null;
    }
}