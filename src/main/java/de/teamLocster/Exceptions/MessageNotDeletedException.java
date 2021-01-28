/*
===================================
== Jakob Gensel
===================================
*/
package de.teamLocster.Exceptions;

public class MessageNotDeletedException extends RuntimeException
{
    public MessageNotDeletedException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message);
    }
}
