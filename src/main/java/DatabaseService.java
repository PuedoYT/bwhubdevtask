import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DatabaseService {

    private MariaDB mariaDB;

    //As an exemple I'm using "usernames" as a way to fetch a list
    public List<String> fetchData(String username, String listName) {
        List<String> data = null;
        CompletableFuture<Void> future = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    Statement statement = mariaDB.getConnection().createStatement();
                    ResultSet results = statement.executeQuery("SELECT * FROM " + mariaDB.getDatabaseName() + " WHERE username=" + username +";");

                    if(results.getFetchSize() < 1 && listName != null) {

                        while(results.next()) {
                            if(results.getArray(listName).getArray() != null) {
                                data.add(String.valueOf(results.getArray(listName)));
                            }
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return data;
    }
}
