package de.teamLocster.Exceptions;

public class FriendlistException extends RuntimeException
{
    public FriendlistException(String message)
    {
        super(message);
        System.out.println( "Error Message: " + message );
    }
}