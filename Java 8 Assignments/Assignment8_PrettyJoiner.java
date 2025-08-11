import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment8_PrettyJoiner {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Pune");
        String result = cities.stream()
                              .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
