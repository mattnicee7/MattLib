package com.github.mattnicee7.sql.datasource.impl;

import com.github.mattnicee7.sql.credentials.impl.SQLiteCredentials;
import com.github.mattnicee7.sql.datasource.DataSource;
import com.github.mattnicee7.sql.exception.DriverNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class SQLite implements DataSource {

    private final String url;

    /**
     *
     */
    public SQLite(@NotNull SQLiteCredentials sqLiteCredentials) throws DriverNotFoundException {
        try {
            this.url = sqLiteCredentials.getUrl();

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

    }

}
