/*
===================================
Saskia Wohlers
Molham Al khodari
Matthias Gabel
Jakob Gensel
===================================
*/
package de.teamLocster.User;


import de.teamLocster.Utility.TestUtility;
import org.junit.jupiter.api.Test;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void user_should_be_added_to_and_deleted_from_blockedUsers(){

        //Given
        User mainUser = TestUtility.getNewUserForTesting();
        User user = new User("Lola", "Lola", "TestUser", "LL@hotmail.de", "PW333", new Date(2003, 3, 3), PersonalInfo.Sex.female);

        //When
        mainUser.addBlockUser(user);

        //Then
        assertTrue(mainUser.getBlockedUsers().contains(user), "user should be in blockedUsers");

        //When
        mainUser.deleteBlockUser(user);

        //Then
        assertFalse(mainUser.getBlockedUsers().contains(user), "user should not be in blockedUsers");
    }

    @Test
    public void should_change_privacy_status(){

        //Given
        User user = new User("Lola", "Lola", "TestUser", "LL@hotmail.de", "PW333", new Date(2003, 3, 3), PersonalInfo.Sex.female);

        //When
        user.setPrivacyStatus(User.PrivacyStatus.global);
        User.PrivacyStatus result = user.getPrivacyStatus();

        //Then
        assertEquals(User.PrivacyStatus.global, result, "The PrivacyStatus should be global!");
    }
}




