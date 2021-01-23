package de.teamLocster.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtility
{
/*
- stringAlreadyeExistInArray(String testString, ArrayList<User> users) : boolean !!!
*/
    public static boolean isValidEmail(String email)
    {
        //Minimum one @
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPassword(String password)
    {
        //Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
        String minimum = "8";
        String specialCharacter = "@$!%*?&";

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*["+specialCharacter+"])[A-Za-z\\d"+specialCharacter+"]{"+minimum+",}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
