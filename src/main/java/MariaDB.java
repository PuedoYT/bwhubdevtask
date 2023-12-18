import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MariaDB {

    @Getter
    public Connection connection;

    @Getter @Setter
    public String databaseName;
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.mariadb.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mariadb://192.168.100.174/" + databaseName, "root", "ROOT");
    }
}
