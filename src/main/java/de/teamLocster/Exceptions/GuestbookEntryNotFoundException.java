/*
===================================
== Jakob Gensel
===================================
*/
package de.teamLocster.Exceptions;

public class GuestbookEntryNotFoundException extends RuntimeException
{
    public GuestbookEntryNotFoundException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message);
    }
}
