/*
===================================
Matthias Gabel
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
        User mainUser = User.getNewUserForTesting();
        User userVisitors0 = new User("Molham",  "test","test000","test000@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors1 = new User("Mohammed","test","test111","test111@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors2 = new User("Matze",   "test","test222","test222@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors3 = new User("Dirk",    "test","test333","test333@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors4 = new User("Saskia",  "test","test444","test444@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors5 = new User("Jakob",   "test","test555","test555@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors6 = new User("Lisa",    "test","test666","test666@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors7 = new User("Maven",   "test","test777","test777@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors8 = new User("Fabian",  "test","test888","test888@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors9 = new User("Jesse",   "test","test999","test999@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors10 = new User("test1!",   "test","test999","test999@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors11 = new User("test2!",   "test","test999","test999@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);


        //When
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors0);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors1);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors2);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors3);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors4);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors5);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors6);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors7);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors8);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors9);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors10);
        mainUser.getProfileStatistic().updateLastVisitors(userVisitors11);

        //Then

        String result = "";
        for (int i = 0; i < 10; i++)
        {
            result = result + mainUser.getProfileStatistic().getLastVisitors()[i].getPersonalInfo().getFirstName() + ", ";
        }


      assertEquals("test2!, test1!, Jesse, Fabian, Maven, Lisa, Jakob, Saskia, Dirk, Matze, ", result, "The last 10 visitor user should be test2!, test1!, Jesse, Fabian, Maven, Lisa, Jakob, Saskia, Dirk, Matze, ");

    }

    @Test
    public void should_return_new_Visits() throws Exception
    {
        //Given
        User mainUser = User.getNewUserForTesting();
        User userVisitors0 = new User("Molham",  "test","test000","test000@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors1 = new User("Mohammed","test","test111","test111@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors2 = new User("Matze",   "test","test222","test222@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors3 = new User("Dirk",    "test","test333","test333@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors4 = new User("Saskia",  "test","test444","test444@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors5 = new User("Jakob",   "test","test555","test555@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors6 = new User("Lisa",    "test","test666","test666@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors7 = new User("Maven",   "test","test777","test777@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors8 = new User("Fabian",  "test","test888","test888@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors9 = new User("Jesse",   "test","test999","test999@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors10 = new User("test1!",   "test","test999","test999@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);
        User userVisitors11 = new User("test2!",   "test","test999","test999@gmail.com","test321.",new Date(2002,6,14),PersonalInfo.Sex.male,PersonalInfo.RelationshipStatus.no_information);


        //When
        mainUser.getProfileStatistic().updateLastVisits(userVisitors0);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors1);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors2);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors3);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors4);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors5);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors6);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors7);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors8);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors9);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors10);
        mainUser.getProfileStatistic().updateLastVisits(userVisitors11);

        //Then

        String result = "";
        for (int i = 0; i < 10; i++)
        {
            result = result + mainUser.getProfileStatistic().getLastVisits()[i].getPersonalInfo().getFirstName() + ", ";
        }


        assertEquals("test2!, test1!, Jesse, Fabian, Maven, Lisa, Jakob, Saskia, Dirk, Matze, ", result, "The last 10 Visits user should be test2!, test1!, Jesse, Fabian, Maven, Lisa, Jakob, Saskia, Dirk, Matze, ");

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



