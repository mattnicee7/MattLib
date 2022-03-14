package com.github.mattnicee7.sql.credentials.impl;

import com.github.mattnicee7.sql.credentials.DatabaseCredentials;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class MariaDBCredentials extends DatabaseCredentials {

    private final String address;
    private final int port;
    private final String database;

    @Getter
    private final String username;

    @Getter
    private final String password;

    public MariaDBCredentials(@NotNull String address, int port, @NotNull String database, @NotNull String username, @NotNull String password) {
        this.address = address;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public static MariaDBCredentials of(@NotNull String address, int port, @NotNull String database, @NotNull String username, @NotNull String password) {
        return new MariaDBCredentials(address, port, database, username, password);
    }

    @Override
    public String getUrl() {
        return "jdbc:mariadb://" + address + ":" + port + "/" + database;
    }

}
