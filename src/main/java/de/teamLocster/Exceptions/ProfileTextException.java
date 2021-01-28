/*
===================================
== Matthias Gabel
===================================
*/
package de.teamLocster.Exceptions;

public class ProfileTextException extends RuntimeException {
    public ProfileTextException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message);
    }
}
