package de.teamLocster.Exceptions;

public class PasswordException extends RuntimeException{
    public PasswordException(String message)
    {
        super( message);
        System.out.println( "Error de.teamLocster.Chat.Message: " + message);
    }
}
