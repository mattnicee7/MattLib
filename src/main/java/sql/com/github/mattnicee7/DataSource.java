package sql.com.github.mattnicee7;

import java.sql.Connection;
import java.sql.SQLException;

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
