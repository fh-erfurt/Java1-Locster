package de.teamLocster.Utility;

import org.junit.jupiter.api.Test;

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
}
