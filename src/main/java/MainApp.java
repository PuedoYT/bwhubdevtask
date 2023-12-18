import java.util.List;

public class MainApp {

    private static DatabaseService databaseService = new DatabaseService();
    private static DataProcessor dataProcessor = new DataProcessor();

    public static void main(String[] args) {
        List<String> fetchedData = databaseService.fetchData("puedo", "test");
        System.out.println(dataProcessor.processData(fetchedData));
    }
}
