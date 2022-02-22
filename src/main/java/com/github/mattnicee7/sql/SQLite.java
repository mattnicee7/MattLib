package com.github.mattnicee7.sql;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLite implements DataSource {

    private final String url;

    public SQLite(@NotNull File file) throws DriverNotFoundException {
        try {
            this.url = "jdbc:sqlite:" + file;

            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException exception) {
            throw new DriverNotFoundException("SQLite driver not found");
        }

    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    @Override
    public void closeConnection() {
        // Not used
    }
}
