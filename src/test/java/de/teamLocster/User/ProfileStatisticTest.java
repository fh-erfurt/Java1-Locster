/*
===================================
Matthias Gabel
Molham Al khodari
===================================
*/
package de.teamLocster.User;


import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;


public class ProfileStatisticTest {

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
        // Could be used to clean up after each test method
    }

    @Test
    public void should_return_new_visitors() throws Exception
    {
        //Given
        User testUser = User.getNewUserForTesting();
        User userVisitors = new User("Molham", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);

        //When
        testUser.getProfileStatistic().updateLastVisitors(userVisitors);

        //Then
        User resultUser = testUser.getProfileStatistic().getLastVisitors()[0];
        String resultUserFirstname = testUser.getProfileStatistic().getLastVisitors()[0].getPersonalInfo().getFirstName();

        assertEquals("Molham", resultUserFirstname, "The las visitor user is Molham");

    }

    @Test
    public void should_return_new_Visits()
    {
        // Given
        User testUser = User.getNewUserForTesting();

        // wir haben 10 User die wir besucht haben
        User userVisits0 = new User("Molham", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits1 = new User("Matze", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits2 = new User("Dirk", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits3 = new User("Saskia", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits4 = new User("Jakob", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits5 = new User("Lisa", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits6 = new User("Maven", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits7 = new User("Fabian", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits8 = new User("Jesse", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);
        User userVisits9 = new User("Mohammed", "Al-khodari","Molham321","molham@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male);

        // When
        testUser.getProfileStatistic().updateLastVisits(userVisits0);
        testUser.getProfileStatistic().updateLastVisits(userVisits1);
        testUser.getProfileStatistic().updateLastVisits(userVisits2);
        testUser.getProfileStatistic().updateLastVisits(userVisits3);
        testUser.getProfileStatistic().updateLastVisits(userVisits4);

        //Then
        User resultUser0 = testUser.getProfileStatistic().getLastVisits()[0];
        String resultUserFirstname0 = testUser.getProfileStatistic().getLastVisits()[0].getPersonalInfo().getFirstName();
        String result = "";

       for (int i = 0; i < 5; i++)  // logik fehler >
       {
           System.out.println(i);
           result = result + testUser.getProfileStatistic().getLastVisits()[i].getPersonalInfo().getFirstName() + ", ";
       }

        assertEquals("Molham, Matze, Dirk, Saskia, Jakob", result, "The last 5 Visits user are Molham, Matze, Dirk, Saskia, Jakob");
    }

    @Test
    public void should_increase_totals_value_by_one() {
        // Given
        ProfileStatistic profileStatistic = new ProfileStatistic();
        // When
        profileStatistic.succTotal();
        int result = profileStatistic.getViewsTotal();

        // Then
        assertEquals(1, result, "viewsTotal value should be 1");
    }
}



