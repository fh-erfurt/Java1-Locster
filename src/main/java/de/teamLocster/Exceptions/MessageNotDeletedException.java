package de.teamLocster.Exceptions;

public class MessageNotDeletedException extends RuntimeException
{
    public MessageNotDeletedException(String message)
    {
        super(message);
    }
}
