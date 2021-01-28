/*
===================================
== Dirk Hofmann
===================================
*/
package de.teamLocster.Exceptions;

public class CannotSendFriendRequestException extends RuntimeException
{
    public CannotSendFriendRequestException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message );
    }
}
