package de.teamLocster.domains.errors;

import java.io.Serial;

public class UserNotFoundException extends Exception {
    @Serial
    private static final long serialVersionUID = -7366814517715710341L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
