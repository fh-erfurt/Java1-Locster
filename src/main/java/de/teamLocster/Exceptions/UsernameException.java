/*
===================================
Matthias Gabel
===================================
*/
package de.teamLocster.Exceptions;

public class UsernameException extends RuntimeException{
    public UsernameException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message);
    }
}
