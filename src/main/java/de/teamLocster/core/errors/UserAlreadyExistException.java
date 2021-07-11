package de.teamLocster.core.errors;

public class UserAlreadyExistException extends Exception
{
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
