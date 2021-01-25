/*
===================================
== edited by
== Molham Al-khodari
== wer hat hier gearbeitet
===================================
*/

package de.teamLocster.User;

import de.teamLocster.User.AccountDetails;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountDetailsTest {

    @Test
    public void should_change_username_to_mickey()
    {
        // Given
        AccountDetails accountdetails = new AccountDetails("SaskiaWo", "saskiawohlers@outlook.de", "Pepsicola" );
        String newusername = "Mickey";

        // When
        accountdetails.setUsername(newusername);
        String result = accountdetails.getUsername();

        // Then
        assertEquals("Mickey", result, "Username should be mickey");
    }

    @Test
    public void should_change_mailadress_to_bjoernathotmailde()
    {
        // Given
        AccountDetails accountdetails = new AccountDetails("SaskiaWo", "saskiawohlers@outlook.de", "Pepsicola" );
        String newmailadress = "bjoernathotmailde";

        // When
        accountdetails.setMailAddress(newmailadress);
        String result = accountdetails.getMailAddress();

        // Then
        assertEquals("bjoernathotmailde", result, "Mailadress should be bjoernathotmailde");
    }

    @Test
    public void should_change_password_to_wurstwasser()
    {
        // Given
        AccountDetails accountdetails = new AccountDetails("SaskiaWo", "saskiawohlers@outlook.de", "Pepsicola" );
        String newpassword = "wurstwasser";

        // When
        accountdetails.setPassword(newpassword);
        String result = accountdetails.getPassword();

        // Then
        assertEquals("wurstwasser", result, "Password should be wurstwasser");
    }

}
