/*
===================================
Matthias Gabel
Molham Al-khodari
===================================
*/
package de.teamLocster.User;


import de.teamLocster.Utility.TestUtility;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.Date;


public class ProfileStatisticTest {

    @Test
    public void should_return_new_visitors() {

        // Given
        UserContainer testUserContainer = new UserContainer();
        User mainUser = TestUtility.getNewUserForTesting();

        for (int i = 0; i < 16; i++)
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
        for (int i = 0; i < 16; i++)
        {
            mainUser.getProfileStatistic().updateLastVisitors(testUserContainer.getUsers().get(i));
        }

        //Then

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++)
        {
            result.append(i + 1).append(". ").append(mainUser.getProfileStatistic().getLastVisitors()[i].getPersonalInfo().getFirstName()).append(", ");
        }


      assertEquals("1. Userfirstname15, 2. Userfirstname14, " +
                            "3. Userfirstname13, 4. Userfirstname12, " +
                            "5. Userfirstname11, 6. Userfirstname10, " +
                            "7. Userfirstname9, 8. Userfirstname8, " +
                            "9. Userfirstname7, 10. Userfirstname6, ", result.toString(),
                  "The last 10 visitor user should Userfirstname15 until Userfirstname6");
      System.out.println(result);

    }

    @Test
    public void should_return_new_Visits() {
        // Given
        UserContainer testUserContainer = new UserContainer();
        User mainUser = TestUtility.getNewUserForTesting();

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
        for (int i = 0; i < 100; i++)
        {
            mainUser.getProfileStatistic().updateLastVisits(testUserContainer.getUsers().get(i));
        }

        //Then

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++)
        {
            result.append(i + 1).append(". ").append(mainUser.getProfileStatistic().getLastVisits()[i].getPersonalInfo().getFirstName()).append(", ");
        }


        assertEquals("1. Userfirstname99, 2. Userfirstname98, " +
                             "3. Userfirstname97, 4. Userfirstname96, " +
                             "5. Userfirstname95, 6. Userfirstname94, " +
                             "7. Userfirstname93, 8. Userfirstname92, " +
                             "9. Userfirstname91, 10. Userfirstname90, ", result.toString(),
                    "The last 10 Visits user should Userfirstname99 until Userfirstname90");
        System.out.println(result);
    }

    @Test
    public void should_increase_totals_value_by_one()
    {
        // Given
        ProfileStatistic profileStatistic = new ProfileStatistic();
        // When
        profileStatistic.succTotal();
        int result = profileStatistic.getViewsTotal();

        // Then
        assertEquals(1, result, "viewsTotal value should be 1");
    }

    @Test
    public void should_put_userB_as_oldest_friend_for_userA()
    {
        // Given
        User userA = TestUtility.getNewUserForTesting();
        User userB = TestUtility.getNewUserForTesting();

        // When
        userA.getProfileStatistic().updateOldestFriend(userA, userB, true);

        // Then
        assertEquals(userB, userA.getProfileStatistic().getOldestFriend(),"we expect userB as the oldest friend of userA ");

    }

    @Test
    public void should_put_userB_as_latest_friend_for_userA()
    {
        // Given
        User userA = TestUtility.getNewUserForTesting();
        User userB = TestUtility.getNewUserForTesting();

        // When
        userA.getProfileStatistic().updateLatestFriend(userA, userB, true);

        // Then
        assertEquals(userB, userA.getProfileStatistic().getLatestFriend(),"we expect userB as the latest friend of userA ");

    }

}



