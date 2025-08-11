import java.util.Scanner;

public class Assignment2_SafeDivider {

     public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter two Numbers:");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = a/b;
		
		if(b==0) {
			System.out.println("Not allowed");
		}
		else {
			System.out.println("Value is" + " " +c);
		}
		
	}
}