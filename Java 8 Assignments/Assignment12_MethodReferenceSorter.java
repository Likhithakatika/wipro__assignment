import java.util.Arrays;
import java.util.List;

public class Assignment12_MethodReferenceSorter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Huzaifa", "Azra", "Prateek", "Anand");
        names.sort(String::compareTo);
        names.forEach(System.out::println);
    }
}
