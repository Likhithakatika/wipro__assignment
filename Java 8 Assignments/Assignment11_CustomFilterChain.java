import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Assignment11_CustomFilterChain {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ananda", "Azra", "Prateeka", "Amit", "Anusha");

        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> endsWithA = name -> name.endsWith("a");

        names.stream()
             .filter(startsWithA.and(endsWithA))
             .forEach(System.out::println);
    }
}
