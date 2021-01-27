package de.teamLocster.User;/*
===================================
Matthias Gabel
Saskia Wohlers
===================================
*/
import de.teamLocster.Exceptions.EmailException;
import de.teamLocster.Exceptions.PasswordException;
import de.teamLocster.Exceptions.UserNameException;
import de.teamLocster.Utility.TestUtility;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


public class UserContainerTest {

    UserContainer testUserContainer = new UserContainer();

    @Test
    public void should_register_max_mustermann(){
        String firstname    = "Max";
        String lastname     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann@fh-email.de";
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;

        testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex);

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
        assertThrows(UserNameException.class, () -> testUserContainer.registerUser(firstname, lastname, "Max", "fh.email@de", password, birthdate, sex));
    }

    @Test
    public void should_change_email_from_user()
    {
        testUserContainer.registerUser("Max", "Mustermann", "MaMu123", "max.mustermann@fh-email.de", "Password123?", new Date(1999, Calendar.JUNE,22), PersonalInfo.Sex.uni);
        User testUser = testUserContainer.getUsers().get(0);
        String newEmail = "meine.geile.email@email.de";
        String falseEmail = "meine.geile.email.email.de";

        testUserContainer.changeEmail(testUser, newEmail);

        assertEquals(newEmail, testUser.getAccountDetails().getMailAddress());
        assertThrows(EmailException.class, ()->testUserContainer.changeEmail(testUser, falseEmail)); //throws invalid Email
        assertThrows(EmailException.class, ()->testUserContainer.changeEmail(testUser, newEmail)); //throws email already exist
    }
    @Test
    public void should_change_password_from_user()
    {
        testUserContainer.registerUser("Max", "Mustermann", "MaMu123", "max.mustermann@fh-email.de", "Password123?", new Date(1999, Calendar.JUNE,22), PersonalInfo.Sex.uni);
        User testUser = testUserContainer.getUsers().get(0);
        String newPassword = "123Password!";
        String falsePassword = "password"; // missing number and specialchar

        testUserContainer.changePassword(testUser, newPassword);

        assertEquals(newPassword, testUser.getAccountDetails().getPassword());
        assertThrows(PasswordException.class, ()->testUserContainer.changePassword(testUser, falsePassword)); //throws invalid Password
    }
    @Test
    public void should_change_username_from_user()
    {
        testUserContainer.registerUser("Max", "Mustermann", "MaMu123", "max.mustermann@fh-email.de", "Password123?", new Date(1999, Calendar.JUNE,22), PersonalInfo.Sex.uni);
        User testUser = testUserContainer.getUsers().get(0);
        String newUsername = "MaMu123465";
        String falseUsername = "MaMu"; // less then 5 chars

        testUserContainer.changeUsername(testUser, newUsername);

        assertEquals(newUsername, testUser.getAccountDetails().getUsername());
        assertThrows(UserNameException.class, ()->testUserContainer.changeUsername(testUser, falseUsername)); //throws invalid Username
    }

    @Test
    public void force_email_already_exist_exception()
    {
        String firstname    = "Max";
        String lastname     = "Mustermann";
        String username     = "MaMus257";
        String email        = "max.mustermann@fh-email.de";
        String password     = "Password123?";
        Date   birthdate    = new Date(1999, Calendar.JUNE,22);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;

        testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex); //already exist

        assertThrows(EmailException.class, () -> testUserContainer.registerUser(firstname, lastname, username, email, password, birthdate, sex));
    }

    @Test
    public void activeUser_should_contain_all_active_user()
    {
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
                    User user = TestUtility.getNewUserForTesting();
                    testUserContainer.getUsers().add(user);
                    testUserContainer.getUsers().get(i).setOnlineStatus(User.OnlineStatus.offline);
                    break;
            }
        }

        ArrayList<User> activeUser = new ArrayList<User>();

        activeUser = testUserContainer.activeUsers();

        assertEquals("Active5",  testUserContainer.getUsers().get(5).getPersonalInfo().getFirstName());
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

        ArrayList<String> result = testUserContainer.getEntireEmailOfAllUsers();

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