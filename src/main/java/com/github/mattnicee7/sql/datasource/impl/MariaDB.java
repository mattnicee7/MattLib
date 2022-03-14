package com.github.mattnicee7.sql.datasource.impl;

import com.github.mattnicee7.sql.credentials.impl.MariaDBCredentials;
import com.github.mattnicee7.sql.datasource.DataSource;
import com.github.mattnicee7.sql.exception.DatabaseConnectionException;
import com.github.mattnicee7.sql.exception.DatabaseDriverNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDB implements DataSource {

    private final Connection connection;

    public MariaDB(@NotNull MariaDBCredentials mariaDBCredentials) throws DatabaseDriverNotFoundException, DatabaseConnectionException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

            connection = DriverManager.getConnection(
                    mariaDBCredentials.getUrl(),
                    mariaDBCredentials.getUsername(),
                    mariaDBCredentials.getPassword());
        } catch (ClassNotFoundException exception) {
            throw new DatabaseDriverNotFoundException("MariaDB Driver not found");
        } catch (SQLException exception) {
            throw new DatabaseConnectionException("Failed to connect with MariaDB");
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            if (!connection.isClosed())
                connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
