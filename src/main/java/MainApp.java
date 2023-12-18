import java.sql.SQLException;
import java.util.List;

public class MainApp {

    private static DatabaseService databaseService = new DatabaseService();
    private static DataProcessor dataProcessor = new DataProcessor();

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        MariaDB db = new MariaDB();
        
        db.setDatabaseLink("jdbc:mariadb://localhost");
        db.setDatabasePort(3306);
        db.setUsername("root");
        db.setPassword("ROOT");
        db.setDatabaseName("test");

        db.connect();
        List<String> fetchedData = databaseService.fetchData("puedo", "test");
        System.out.println(dataProcessor.processData(fetchedData));
    }
}
