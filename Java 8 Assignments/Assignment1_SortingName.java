import java.util.ArrayList;
import java.util.List;

public class Assignment1_SortingName {
    public static void main(String[] args) {
	List<String> list = new ArrayList<>();
	list.add("Huzaifa");
	list.add("Azra");
	list.add("Prateek");
	list.add("Anand");
	
	list.sort((a,b) -> a.compareTo(b));
	for(String List : list) {
		System.out.println(List);
	}
		}
}
