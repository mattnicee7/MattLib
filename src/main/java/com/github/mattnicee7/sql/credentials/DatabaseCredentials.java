package com.github.mattnicee7.sql.credentials;

/**
 *
 */
public abstract class DatabaseCredentials {

    /**
     * Generate the correct connection link to connect to the database.
     *
     * @return The correct connection link.
     */
    public abstract String getUrl();

}
