package de.teamLocster.core.errors;

import java.io.Serial;

public class SqlException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = -2531075974010600114L;

    public SqlException(String message, Throwable cause) {
        super(message, cause);
    }
}
