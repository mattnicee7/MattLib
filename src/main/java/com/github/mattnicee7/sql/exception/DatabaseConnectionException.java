package com.github.mattnicee7.sql.exception;

/**
 *
 */
public class DatabaseConnectionException extends Exception {

    /**
     *
     */
    public DatabaseConnectionException(String message) {
        super(message);
    }

    /**
     *
     */
    public DatabaseConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     */
    public DatabaseConnectionException(Throwable cause) {
        super(cause);
    }

}
