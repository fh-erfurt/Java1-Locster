/*
===================================
Matthias Gabel
===================================
*/

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
        User testUser   = new User();
        User user1      = new User();
        User user2      = new User();
        User user3      = new User();
        User user4      = new User();
        User user5      = new User();
        User user6      = new User();
        User user7      = new User();
        User user8      = new User();
        User user9      = new User();
        User user10     = new User();
        User user11     = new User();

        // When


        // Then
    }

}
