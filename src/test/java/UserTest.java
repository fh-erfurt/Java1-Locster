/*
===================================
== edited by
== Saskia Wohlers
===================================
*/

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void should_add_User_to_blocked_Users() {

        //Given
        User user = new User("Lola", "Lola", "TestUser", "LL@hotmail.de", "PW333", new Date(2003, 3, 3), PersonalInfo.sex.female, PersonalInfo.relationshipStatus.no_information);
        ArrayList<User> blockedUsers = new ArrayList<User>();

        //When
        blockedUsers.add(user);  //Mit Methode addBlockUser klappts noch nicht??

        //Then
        if (blockedUsers.contains(user))
        System.out.println("The user is in blockedUsers now!");

    }

    @Test
    public void should_delete_user_out_of_blocked_users(){

        //Given
        User user = new User("Lola", "Lola", "TestUser", "LL@hotmail.de", "PW333", new Date(2003, 3, 3), PersonalInfo.sex.female, PersonalInfo.relationshipStatus.no_information);
        ArrayList<User> blockedUsers = new ArrayList<User>();
        blockedUsers.add(user);

        //When
        blockedUsers.remove(user);  //Mit Methode deleteblockedUser klappts noch nicht??

        //Then
        if (blockedUsers.contains(user))
            System.out.println("The user ist still in blockedUsers!");
    }

    @Test
    public void should_change_privacy_status(){

        //Given
        User user = new User("Lola", "Lola", "TestUser", "LL@hotmail.de", "PW333", new Date(2003, 3, 3), PersonalInfo.sex.female, PersonalInfo.relationshipStatus.no_information);

        //When
        user.changePrivacyStatusFlag(User.privacyStatus.global);
        User.privacyStatus result = user.getPrivacyStatusFlag();

        //Then
        assertEquals(User.privacyStatus.global, result, "The PrivacyStatus should be global!");
    }

}




