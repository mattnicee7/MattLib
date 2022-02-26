package com.github.mattnicee7.sql.datasource.factory;

import com.github.mattnicee7.sql.credentials.impl.MySQLCredentials;
import com.github.mattnicee7.sql.credentials.impl.SQLiteCredentials;
import com.github.mattnicee7.sql.datasource.impl.MySQL;
import com.github.mattnicee7.sql.datasource.impl.SQLite;
import com.github.mattnicee7.sql.datasource.DataSource;
import com.github.mattnicee7.sql.exception.DatabaseConnectionException;
import com.github.mattnicee7.sql.exception.DriverNotFoundException;
import org.jetbrains.annotations.NotNull;

/**
 *
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
     *                      DatabaseCredentials.of(address, port, database, username, password)
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

}
