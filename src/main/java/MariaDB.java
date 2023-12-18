import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDB {

    @Getter
    public Connection connection;

    @Getter @Setter
    public String databaseLink, databaseName, username, password;

    @Setter
    public int databasePort;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection(databaseLink + "/" + databasePort + "/" + databaseName, username, password);
    }
}
