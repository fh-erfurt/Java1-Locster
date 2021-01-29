/*
===================================
== Matthias Gabel
== Saskia Wohlers
===================================
*/
package de.teamLocster.Utility;

import de.teamLocster.User.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtility
{
    /**
     * iterates a string list and compares if the inputString already exist
     * @param inputString string that should be compare
     * @param stringList list that should be compare
     * @return the result of the comparison
     */
    public static boolean stringAlreadyExistInArray(String inputString, ArrayList<String> stringList)
    {

        for (String value : stringList)
        {
            if(value.equals(inputString))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * validates the email address of a user
     * @param email email address of user
     * @return true if the email address matches a @ character
     */
    public static boolean isValidEmail(String email)
    {
        //Minimum one @
        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * validates the password of a user
     * @param password password of a user
     * @return true if the email address matches following constraint: Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
     */
    public static boolean isValidPassword(String password)
    {
        //Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character
        String minimum = "8";
        String specialCharacter = "@$!%*?&.";

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*["+specialCharacter+"])[A-Za-z\\d"+specialCharacter+"]{"+minimum+",}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    /**
     * calidates the user name of a user
     * @param username user name of user
     * @return true if the length of the user name is greater then 5
     */
    public static boolean isValidUsername(String username)
    {
        //Minimum 5 Chars
        return username.length() >= 5;
    }
}
