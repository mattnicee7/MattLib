package com.github.mattnicee7.sql.exception;

/**
 *
 */
public class DriverNotFoundException extends Exception {

    /**
     *
     */
    public DriverNotFoundException(String message) {
        super(message);
    }

    /**
     *
     */
    public DriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     *
     */
    public DriverNotFoundException(Throwable cause) {
        super(cause);
    }

}
