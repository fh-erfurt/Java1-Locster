/*
===================================
Matthias Gabel
===================================
*/
package de.teamLocster.Exceptions;

public class UserNameException extends RuntimeException{
    public UserNameException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message);
    }
}
