import java.util.Arrays;
import java.util.List;

public class Assignment6_WordCounter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anand", "Huzaifa", "Azra", "Prateek", "Mohammed");
        long count = names.stream()
                          .filter(name -> name.length() > 5)
                          .count();
        System.out.println("Names longer than 5 chars: " + count);
    }
}
