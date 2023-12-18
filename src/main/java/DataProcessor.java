import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

    public List<String> processData(List<String> string) {
        List<String> result = new ArrayList<>();
        if(string != null) {
            for(String s : string) {
                result.add(s.toUpperCase());
            }
        }
        return result;
    }
}
