package de.teamLocster.User;

import de.teamLocster.Exceptions.ProfileTextException;
import de.teamLocster.Exceptions.UserNameException;
import de.teamLocster.Utility.TestUtility;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ProfileTextTest {


    UserContainer testUserContainer = new UserContainer();

    @Test
    public void should_change_profile_text()
    {
        //Given
        User testUser = TestUtility.getNewUserForTesting();

        //When
        String newText = "Hallo Welt!";
        testUser.getProfileText().changeProfileText(newText);


        String tooBigString = "This will be to big!" + "!".repeat(10000);

        //Then
        assertEquals(newText, testUser.getProfileText().getContent());
        assertThrows(ProfileTextException.class, () -> testUser.getProfileText().changeProfileText(tooBigString));
    }
}
