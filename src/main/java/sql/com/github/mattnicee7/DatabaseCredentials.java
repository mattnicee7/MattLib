package sql.com.github.mattnicee7;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Getter
public class DatabaseCredentials {

    private final String address;
    private final int port;
    private final String database;
    private final String username;
    private final String password;

    public static DatabaseCredentials of(@NotNull String address, int port, @NotNull String database, @NotNull String username, @NotNull String password) {
        return new DatabaseCredentials(address, port, database, username, password);
    }

    public String getUrl() {
        return "jdbc:mysql://" + address + ":" + port + "/" + database + "?autoReconnect=true";
    }

}
