package de.teamLocster.Utility;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ValidationUtilityTest
{
    @Test
    public void should_test_email()
    {
        // Given
        String validEmail = "max.mueller@fh-email.de";
        String invalidEmail = "max.mueller.fh-email.de";

        // When
        boolean result1 = ValidationUtility.isValidEmail(validEmail);
        boolean result2 = ValidationUtility.isValidEmail(invalidEmail);

        // Then
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void should_test_password()
    {
        //Given
        String validPassword = "Pikachu?0";
        String invalidPassword = "picho";

        //When
        boolean result1 = ValidationUtility.isValidPassword(validPassword);
        boolean result2 = ValidationUtility.isValidPassword(invalidPassword);

        //Then
        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    public void should_check_if_email_is_already_in_use() {
        //Given
        String emailToTest1 = "max.mustermann5@fh-email.de";
        String emailToTest2 = "lisa.lapislazuli@fh-email.de";
        ArrayList<String> emailContainer = new ArrayList<String>();
        String email = "";

        for (int i = 0; i < 10; i++)
        {
            email       = "max.mustermann"+ i +"@fh-email.de";

            emailContainer.add(email);
        }

        //When
         boolean result1 = ValidationUtility.stringAlreadyExistInArray(emailToTest1, emailContainer);
         boolean result2 = ValidationUtility.stringAlreadyExistInArray(emailToTest2, emailContainer);

        //Then
        assertTrue(result1);
        assertFalse(result2);
    }
}
