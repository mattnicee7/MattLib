package com.github.mattnicee7.sql.datasource.impl;

import com.github.mattnicee7.sql.credentials.impl.MySQLCredentials;
import com.github.mattnicee7.sql.datasource.DataSource;
import com.github.mattnicee7.sql.exception.DatabaseConnectionException;
import com.github.mattnicee7.sql.exception.DriverNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for storing the connection with MySQL. You can close the connection whenever you want.
 */
public class MySQL implements DataSource {

    private final Connection connection;

    /**
     *
     */
    public MySQL(@NotNull MySQLCredentials mySQLCredentials) throws DatabaseConnectionException, DriverNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            this.connection = DriverManager.getConnection(
                    mySQLCredentials.getUrl(),
                    mySQLCredentials.getUsername(),
                    mySQLCredentials.getPassword()
            );
            
        } catch (SQLException exception) {
            throw new DatabaseConnectionException("Failed to connect with MySQL");
        } catch (ClassNotFoundException exception) {
            throw new DriverNotFoundException("MySQL Driver not found.");
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

}
