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

package com.github.mattnicee7.mattlib.datasource.impl;

import com.github.mattnicee7.mattlib.credentials.impl.MySQLCredentials;
import com.github.mattnicee7.mattlib.datasource.DataSource;
import com.github.mattnicee7.mattlib.exception.DatabaseConnectionException;
import com.github.mattnicee7.mattlib.exception.DatabaseDriverNotFoundException;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class responsible for storing the connection with MySQL. You can close the connection whenever you want.
 */
public class MySQL implements DataSource {

    private final Connection connection;

    public MySQL(@NotNull MySQLCredentials mySQLCredentials) throws DatabaseConnectionException, DatabaseDriverNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            this.connection = DriverManager.getConnection(
                    mySQLCredentials.getUrl(),
                    mySQLCredentials.getUsername(),
                    mySQLCredentials.getPassword()
            );
            
        } catch (ClassNotFoundException exception) {
            throw new DatabaseDriverNotFoundException("MySQL Driver not found.");
        } catch (SQLException exception) {
            throw new DatabaseConnectionException("Failed to connect with MySQL.");
        }
    }

    @Override
    public Connection getConnection() {
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
