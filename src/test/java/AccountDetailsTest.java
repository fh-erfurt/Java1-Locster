import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountDetailsTest {

    @Test
    public void should_change_username_to_mickey()
    {
        // Given
        AccountDetails accountdetails = new AccountDetails(1, "SaskiaWo", "saskiawohlers@outlook.de", "Pepsicola" );
        String newusername = "Mickey";

        // When
        accountdetails.changeUserName(newusername);
        String result = accountdetails.getUsername();

        // Then
        assertEquals("Mickey", result, "Username should be mickey");
    }

    @Test
    public void should_change_mailadress_to_bjoernathotmailde()
    {
        // Given
        AccountDetails accountdetails = new AccountDetails(1, "SaskiaWo", "saskiawohlers@outlook.de", "Pepsicola" );
        String newmailadress = "bjoernathotmailde";

        // When
        accountdetails.changeMailadress(newmailadress);
        String result = accountdetails.getMailadress();

        // Then
        assertEquals("bjoernathotmailde", result, "Mailadress should be bjoernathotmailde");
    }

    @Test
    public void should_change_password_to_wurstwasser()
    {
        // Given
        AccountDetails accountdetails = new AccountDetails(1, "SaskiaWo", "saskiawohlers@outlook.de", "Pepsicola" );
        String newpassword = "wurstwasser";

        // When
        accountdetails.changePassword(newpassword);
        String result = accountdetails.getPassword();

        // Then
        assertEquals("wurstwasser", result, "Password should be wurstwasser");
    }

}
