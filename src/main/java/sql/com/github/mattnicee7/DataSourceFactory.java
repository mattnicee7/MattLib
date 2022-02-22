package sql.com.github.mattnicee7;

import org.jetbrains.annotations.NotNull;

import java.io.File;

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
     *             DataSource dataSource = DataSourceFactory.createSQLiteDataSource(new File(path));
     *
     *             // Do something with dataSource (...)
     *         } catch (DriverNotFoundException) {
     *             exception.printStackTrace();
     *         }
     *     }
     * }}</pre>
     *
     *
     * @param file
     *        File with extension .db to use on connection.
     *
     * @throws DriverNotFoundException
     *         <ul type="disc">
     *             <li>If the SQLite driver was not found.</li>
     *         </ul>
     *
     * @return A datasource with the SQLite connection.
     */
    public static DataSource createSQLiteDataSource(@NotNull File file) throws DriverNotFoundException {
        return new SQLite(file);
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
     * @param databaseCredentials
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
    public static DataSource createMySQLDataSource(@NotNull DatabaseCredentials databaseCredentials) throws DatabaseConnectionException, DriverNotFoundException {
        return new MySQL(databaseCredentials);
    }

}
