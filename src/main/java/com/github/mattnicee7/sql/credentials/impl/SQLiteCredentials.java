package com.github.mattnicee7.sql.credentials.impl;

import com.github.mattnicee7.sql.credentials.DatabaseCredentials;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * Class responsible for storing credentials of a SQLite database.
 */
public class SQLiteCredentials extends DatabaseCredentials {

    private final File file;

    public SQLiteCredentials(@NotNull File file) {
        this.file = file;
    }

    public static SQLiteCredentials of(@NotNull File file) {
        return new SQLiteCredentials(file);
    }

    @Override
    public String getUrl() {
        return "jdbc:sqlite:" + file;
    }

}
