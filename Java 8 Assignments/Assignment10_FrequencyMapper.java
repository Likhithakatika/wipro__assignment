import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Assignment10_FrequencyMapper {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Huzaifa", "Azra", "Huzaifa", "Anand", "Azra");
        Map<String, Long> frequencyMap = names.stream()
                                              .collect(Collectors.groupingBy(name -> name, Collectors.counting()));
        System.out.println(frequencyMap);
    }
}
