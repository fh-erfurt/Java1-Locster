package de.teamLocster.Exceptions;

public class MessageNotFoundException extends RuntimeException
{
    public MessageNotFoundException(String message)
    {
        super(message);
    }
}
