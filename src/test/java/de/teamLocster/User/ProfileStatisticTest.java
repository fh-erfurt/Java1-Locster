package de.teamLocster.User;/*
===================================
Matthias Gabel
===================================
*/

import de.teamLocster.User.ProfileStatistic;
import de.teamLocster.User.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileStatisticTest {

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
    public void should_update_lastVisitors()
    {
        // Given
        User testUser   = User.getNewUserForTesting();
        User user1      = User.getNewUserForTesting();
        User user2      = User.getNewUserForTesting();
        User user3      = User.getNewUserForTesting();
        User user4      = User.getNewUserForTesting();
        User user5      = User.getNewUserForTesting();
        User user6      = User.getNewUserForTesting();
        User user7      = User.getNewUserForTesting();
        User user8      = User.getNewUserForTesting();
        User user9      = User.getNewUserForTesting();
        User user10     = User.getNewUserForTesting();
        User user11     = User.getNewUserForTesting();

        // When


        // Then
    }

}
