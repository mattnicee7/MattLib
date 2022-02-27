package com.github.mattnicee7.sql.datasource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Class responsible for providing a connection to the database,
 * and methods to get the connection to use, and close the connection
 * when you no longer use it.
 */
public interface DataSource {

    /**
     * Get the DataSource connection.
     *
     * @throws SQLException
     *         <ul type="disc">
     *             <li>If something went wrong in the syntax.</li>
     *         </ul>
     *
     * @return DataSource connection.
     */
    Connection getConnection() throws SQLException;

    /**
     * Close the DataSource connection.
     * */
    void closeConnection();

}
