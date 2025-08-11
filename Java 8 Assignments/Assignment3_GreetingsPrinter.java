@FunctionalInterface
interface MessagePrinter {
    void print(String message);
}

public class Assignment3_GreetingsPrinter {
    public static void main(String[] args) {
        greet("Hello, Huzaifa!", msg -> System.out.println(msg));
    }

    static void greet(String message, MessagePrinter printer) {
        printer.print(message);
    }
}
