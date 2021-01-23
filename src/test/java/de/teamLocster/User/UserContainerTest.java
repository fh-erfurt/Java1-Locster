package de.teamLocster.User;/*
===================================
Matthias Gabel
===================================
*/
import de.teamLocster.Exceptions.EmailException;
import de.teamLocster.Exceptions.PasswordException;
import de.teamLocster.Utility.ValidationUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class UserContainerTest {

    // Given
    UserContainer testUserContainer = new UserContainer();

    @Test
    public void should_test_if_email_is_correct_and_unique()
    {
        //Given
        User Test1 = User.getNewUserForTesting();
        User Test2 = User.getNewUserForTesting();
        Test2.getAccountDetails().setMailAddress("User50@email.de");

        for (int i = 0; i < 100; i++)
        {
            String firstName = "Userfirstname" + i;
            String lastName = "Userlastname" + i;
            String userName = "Username" + 1;
            String email = "User" + i + "@email.de";
            String password = "ActiveUserPW" + i + "!";
            Date birthday = new Date(1999, Calendar.JUNE,22);
            PersonalInfo.Sex sex = PersonalInfo.Sex.uni;
            testUserContainer.registerUser(firstName, lastName, userName, email, password, birthday, sex);
            testUserContainer.getUsers().get(i).setOnlineStatus(User.OnlineStatus.online);
        }
        //When
        boolean result1 = testUserContainer.checkEmail(Test1.getAccountDetails().getMailAddress());

        //Then
        assertTrue(result1);
        assertThrows(EmailException.class, ()->testUserContainer.checkEmail(Test2.getAccountDetails().getMailAddress()));
    }

    @Test
    public void should_test_if_password_is_valid()
    {

        //Given
        String validPassword = "Pikachu?0";
        String invalidPassword = "picho";

        //When
        boolean result1 = testUserContainer.checkPassword(validPassword);

        //Then
        assertTrue(result1);
        assertThrows(PasswordException.class, () -> testUserContainer.checkPassword(invalidPassword));
    }

    @Test
    public void should_register_max_mustermann(){
        // Given
        String firstname    = "Max";
        String lastname     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann@fh-email.de";
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;

        // When
        testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex);

        // Then
        assertEquals("MaMus257",                            testUserContainer.getUsers().get(0).getAccountDetails().getUsername());
        assertEquals("Max",                                 testUserContainer.getUsers().get(0).getPersonalInfo().getFirstName());
        assertEquals("Mustermann",                          testUserContainer.getUsers().get(0).getPersonalInfo().getLastName());
        assertEquals("max.mustermann@fh-email.de",          testUserContainer.getUsers().get(0).getAccountDetails().getMailAddress());
        assertEquals("Password123?",                        testUserContainer.getUsers().get(0).getAccountDetails().getPassword());
        assertEquals(new Date(1999, Calendar.JUNE,22),    testUserContainer.getUsers().get(0).getPersonalInfo().getBirthdate());
        assertEquals(PersonalInfo.Sex.male,                         testUserContainer.getUsers().get(0).getPersonalInfo().getSex());
        assertThrows(EmailException.class, () -> testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex));
        assertThrows(EmailException.class, () -> testUserContainer.registerUser(firstname, lastname, username, "fh.email.de", password, birthdate, sex));
        assertThrows(PasswordException.class, () -> testUserContainer.registerUser(firstname, lastname, username, "email@email.de", "password", birthdate, sex));
    }

    @Test
    public void force_email_already_exist_exception()
    {
        //Given
        String firstname    = "Max";
        String lastname     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann@fh-email.de";
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;

        testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex); //already exist
        //When
        //Then
        assertThrows(EmailException.class, () -> testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex));

    }

    @Test
    public void force_email_invalid_exception()
    {
        //Given
        String firstname    = "Max";
        String lastname     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann.fh-email.de"; // missing @
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;
        //When
        //Then
        assertThrows(EmailException.class, () -> testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex));
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

    @Test
    public void should_store_all_emails_in_one_list()
    {
        //Given
        String firstName    = "Max";
        String lastName     = "Mustermann";
        String username     = "MaMus257";
        String email        = "";
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;
        for (int i = 0; i < 20; i++)
        {
            email        = "max.mustermann"+ i +"@fh-email.de";
            testUserContainer.registerUser(firstName, lastName, username, email, password, birthdate, sex);
        }

        //When
        ArrayList<String> result = testUserContainer.getEntireEmailOfAllUsers();

        //Then
        assertEquals("max.mustermann0@fh-email.de", result.get(0));
        assertEquals("max.mustermann1@fh-email.de", result.get(1));
        assertEquals("max.mustermann2@fh-email.de", result.get(2));
        assertEquals("max.mustermann3@fh-email.de", result.get(3));
        assertEquals("max.mustermann4@fh-email.de", result.get(4));
        assertEquals("max.mustermann5@fh-email.de", result.get(5));
    }

    @Test
    public void should_delete_user()
    {
        //Given
        for (int i = 0; i < 100; i++)
        {
            String firstName = "Userfirstname" + i;
            String lastName = "Userlastname" + i;
            String userName = "Username" + 1;
            String email = "User" + i + "@email.de";
            String password = "ActiveUserPW" + i + "!";
            Date birthday = new Date(1999, Calendar.JUNE,22);
            PersonalInfo.Sex sex = PersonalInfo.Sex.uni;
            testUserContainer.registerUser(firstName, lastName, userName, email, password, birthday, sex);
            testUserContainer.getUsers().get(i).setOnlineStatus(User.OnlineStatus.online);
        }
        //When
        User TestDeleteUser = testUserContainer.getUsers().get(50);
        testUserContainer.deleteUser(TestDeleteUser);

        //Then
        assertEquals("Userfirstname49", testUserContainer.getUsers().get(49).getPersonalInfo().getFirstName());
        assertEquals("Userfirstname51", testUserContainer.getUsers().get(50).getPersonalInfo().getFirstName());
    }
}