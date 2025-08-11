import java.util.Arrays;
import java.util.List;

public class Assignment5_ANameFinder {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anand", "Huzaifa", "Azra", "Prateek", "Amit");
        names.stream()
             .filter(name -> name.startsWith("A"))
             .forEach(System.out::println);
    }
}
