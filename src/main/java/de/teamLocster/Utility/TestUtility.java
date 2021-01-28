/*
===================================
== Matthias Gabel
===================================
*/
package de.teamLocster.Utility;

import de.teamLocster.User.*;

import java.util.Date;

public class TestUtility {

    public static User getNewUserForTesting()
    {
        String firstname = "Max";
        String lastname = "Mustermann";
        String username = "MaMu257";
        String email = "max.mustermann@fh-email.de";
        String password = "Password123?";
        Date birthdate = new Date(1999, 3,2);
        PersonalInfo.Sex sex = PersonalInfo.Sex.male;


        return new User(firstname, lastname, username, email, password, birthdate, sex);
    }
}
