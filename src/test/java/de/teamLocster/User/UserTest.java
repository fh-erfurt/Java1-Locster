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

    @Test
    public void should_visit_other_user_and_updates_the_statistics_() {
        //Given
        User max = TestUtility.getNewUserForTesting();
        max.getPersonalInfo().setFirstName("Max");
        User peter = TestUtility.getNewUserForTesting();
        peter.getPersonalInfo().setFirstName("Peter");
        User lisa = TestUtility.getNewUserForTesting();
        lisa.getPersonalInfo().setFirstName("Lisa");
        User brunhilde = TestUtility.getNewUserForTesting();
        brunhilde.getPersonalInfo().setFirstName("Brunhilde");
        //When
        max.visitUser(lisa);
        max.visitUser(peter);
        max.visitUser(brunhilde);
        lisa.visitUser(max);
        lisa.visitUser(brunhilde);
        brunhilde.visitUser(peter);
        //Then
        assertEquals("Brunhilde", max.getProfileStatistic().      getLastVisits()[0].getPersonalInfo().getFirstName());
        assertEquals("Peter",     max.getProfileStatistic().      getLastVisits()[1].getPersonalInfo().getFirstName());
        assertEquals("Lisa",      max.getProfileStatistic().      getLastVisits()[2].getPersonalInfo().getFirstName());
        assertEquals("Brunhilde", lisa.getProfileStatistic().     getLastVisits()[0].getPersonalInfo().getFirstName());
        assertEquals("Max",       lisa.getProfileStatistic().     getLastVisits()[1].getPersonalInfo().getFirstName());
        assertEquals("Peter",     brunhilde.getProfileStatistic().getLastVisits()[0].getPersonalInfo().getFirstName());

        assertEquals("Lisa",      max.getProfileStatistic().      getLastVisitors()[0].getPersonalInfo().getFirstName());
        assertEquals("Max",       lisa.getProfileStatistic().     getLastVisitors()[0].getPersonalInfo().getFirstName());
        assertEquals("Brunhilde", peter.getProfileStatistic().    getLastVisitors()[0].getPersonalInfo().getFirstName());
        assertEquals("Max",       peter.getProfileStatistic().    getLastVisitors()[1].getPersonalInfo().getFirstName());
        assertEquals("Lisa",      brunhilde.getProfileStatistic().getLastVisitors()[0].getPersonalInfo().getFirstName());
        assertEquals("Max",       brunhilde.getProfileStatistic().getLastVisitors()[1].getPersonalInfo().getFirstName());

    }

}




