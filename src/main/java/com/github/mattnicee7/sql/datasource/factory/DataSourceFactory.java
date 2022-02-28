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

package com.github.mattnicee7.sql.datasource.factory;

import com.github.mattnicee7.sql.credentials.impl.MySQLCredentials;
import com.github.mattnicee7.sql.credentials.impl.PostgreSQLCredentials;
import com.github.mattnicee7.sql.credentials.impl.SQLiteCredentials;
import com.github.mattnicee7.sql.datasource.impl.MySQL;
import com.github.mattnicee7.sql.datasource.impl.PostgreSQL;
import com.github.mattnicee7.sql.datasource.impl.SQLite;
import com.github.mattnicee7.sql.datasource.DataSource;
import com.github.mattnicee7.sql.exception.DatabaseConnectionException;
import com.github.mattnicee7.sql.exception.DriverNotFoundException;
import org.jetbrains.annotations.NotNull;

/**
 * Useful class to create database connections. You can create a connection with MySQL and SQLite.
 */
public class DataSourceFactory {

    /**
     * Create a DataSource with SQLite file.
     *
     * <h2> Example Usage
     * <pre>
     *     {@code
     * public class Application {
     *     public static void main(String[] args) {
     *         try {
     *             DataSource dataSource = DataSourceFactory.createSQLiteDataSource(
     *                      SQLiteCredentials.of(new File(path))
     *              );
     *
     *             // Do something with dataSource (...)
     *         } catch (DriverNotFoundException exception) {
     *             exception.printStackTrace();
     *         }
     *     }
     * }}</pre>
     *
     *
     * @param sqLiteCredentials
     *        Credentials of the SQLite Database
     *
     * @throws DriverNotFoundException
     *         <ul type="disc">
     *             <li>If the SQLite driver was not found.</li>
     *         </ul>
     *
     * @return A datasource with the SQLite connection.
     */
    public static DataSource createSQLiteDataSource(@NotNull SQLiteCredentials sqLiteCredentials) throws DriverNotFoundException {
        return new SQLite(sqLiteCredentials);
    }

    /**
     * Create a DataSource with MySQL Url.
     *
     * <h2> Example Usage
     * <pre>
     *     {@code
     * public class Application {
     *     public static void main(String[] args) {
     *         try {
     *             DataSource dataSource = DataSourceFactory.createMySQLDataSource(
     *                      MySQLCredentials.of(address, port, database, username, password)
     *             );
     *
     *             // Do something with the dataSource (...)
     *         } catch (DatabaseConnectionException exception) {
     *             System.out.println("DatabaseConnection Error: " + exception.getMessage();
     *         } catch (DriverNotFoundException exception) {
     *             System.out.println("DriverNotFound Error: " + exception.getMessage();
     *         }
     *     }
     * }}</pre>
     *
     * @param mySQLCredentials
     *        Credentials of the MySQL Database.
     *
     * @throws DatabaseConnectionException
     *         <ul type="disc">
     *             <li>If the credentials is wrong.</li>
     *         </ul>
     *
     * @throws DriverNotFoundException
     *         <ul type="disc">
     *             <li>If the MySQL driver was not found.</li>
     *         </ul>
     *
     * @return A datasource with MySQL connection.
     *
     * */
    public static DataSource createMySQLDataSource(@NotNull MySQLCredentials mySQLCredentials) throws DatabaseConnectionException, DriverNotFoundException {
        return new MySQL(mySQLCredentials);
    }

    /**
     * Create a DataSource with PostgreSQL Url.
     *
     * <h2> Example Usage
     * <pre>
     *     {@code
     * public class Application {
     *     public static void main(String[] args) {
     *         try {
     *             DataSource dataSource = DataSourceFactory.createMySQLDataSource(
     *                      PostgreSQLCredentials.of(address, port, database, username, password)
     *             );
     *
     *             // Do something with the dataSource (...)
     *         } catch (DatabaseConnectionException exception) {
     *             System.out.println("DatabaseConnection Error: " + exception.getMessage();
     *         } catch (DriverNotFoundException exception) {
     *             System.out.println("DriverNotFound Error: " + exception.getMessage();
     *         }
     *     }
     * }}</pre>
     *
     * @param postgreSQLCredentials
     *        Credentials of the PostgreSQL Database.
     *
     * @throws DatabaseConnectionException
     *         <ul type="disc">
     *             <li>If the credentials is wrong.</li>
     *         </ul>
     *
     * @throws DriverNotFoundException
     *         <ul type="disc">
     *             <li>If the PostgreSQL driver was not found.</li>
     *         </ul>
     *
     * @return A datasource with PostgreSQL connection.
     *
     * */
    public static DataSource createPostgreSQLDataSource(@NotNull PostgreSQLCredentials postgreSQLCredentials) throws DriverNotFoundException, DatabaseConnectionException {
        return new PostgreSQL(postgreSQLCredentials);
    }

}
