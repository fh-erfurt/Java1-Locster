/*
===================================
== Jakob Gensel
===================================
*/
package de.teamLocster.Exceptions;

public class MessageNotFoundException extends RuntimeException
{
    public MessageNotFoundException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message);
    }
}
