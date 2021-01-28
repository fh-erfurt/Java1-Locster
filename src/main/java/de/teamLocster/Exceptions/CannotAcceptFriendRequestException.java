/*
===================================
== Dirk Hofmann
===================================
*/
package de.teamLocster.Exceptions;

public class CannotAcceptFriendRequestException extends RuntimeException
{
    public CannotAcceptFriendRequestException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message );
    }
}
