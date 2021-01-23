package de.teamLocster.Utility;

import de.teamLocster.User.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtility
{
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
