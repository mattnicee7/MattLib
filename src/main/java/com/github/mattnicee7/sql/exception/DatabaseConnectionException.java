package com.github.mattnicee7.sql.exception;

/**
 * Custom exception used when something in the attempt to connect to the database goes wrong, such as wrong credentials, etc.
 */
public class DatabaseConnectionException extends Exception {

    public DatabaseConnectionException(String message) {
        super(message);
    }

    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseConnectionException(Throwable cause) {
        super(cause);
    }

}
