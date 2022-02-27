package com.github.mattnicee7.sql.exception;

/**
 * Custom exception used when some database driver is not found. Probably an error in your project
 */
public class DriverNotFoundException extends Exception {

    public DriverNotFoundException(String message) {
        super(message);
    }

    public DriverNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public DriverNotFoundException(Throwable cause) {
        super(cause);
    }

}
