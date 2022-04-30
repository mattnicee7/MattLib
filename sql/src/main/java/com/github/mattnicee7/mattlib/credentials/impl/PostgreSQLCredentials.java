/*
 * This file is part of MattLib, licensed under the MIT License.
 *
 *  Copyright (c) mattnicee7
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */

package com.github.mattnicee7.mattlib.credentials.impl;

import com.github.mattnicee7.mattlib.credentials.DatabaseCredentials;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public class PostgreSQLCredentials implements DatabaseCredentials {

    private final String address;
    private final int port;
    private final String database;

    @Getter
    private final String username;

    @Getter
    private final String password;

    public PostgreSQLCredentials(@NotNull String address, int port, @NotNull String database, @NotNull String username, @NotNull String password) {
        this.address = address;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    public static PostgreSQLCredentials of(@NotNull String address, int port, @NotNull String database, @NotNull String username, @NotNull String password) {
        return new PostgreSQLCredentials(address, port, database, username, password);
    }

    @Override
    public String getUrl() {
        return "jdbc:postgresql://" + address + ":" + port + "/" + database;
    }

}
