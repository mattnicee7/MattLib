package sql.com.github.mattnicee7;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL implements DataSource{

    private final Connection connection;

    public MySQL(@NotNull DatabaseCredentials databaseCredentials) throws DatabaseConnectionException, DriverNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(databaseCredentials.getUrl(), databaseCredentials.getUsername(), databaseCredentials.getPassword());
        } catch (SQLException exception) {
            throw new DatabaseConnectionException("Failed to connect with MySQL");
        } catch (ClassNotFoundException exception) {
            throw new DriverNotFoundException("MySQL Driver not found.");
        }
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
}
