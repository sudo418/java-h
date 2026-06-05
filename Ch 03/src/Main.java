import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Strings are immutable and cannot be changed
        // Strings can be instantiated in java by 2 methods :-

        String name = new String("Hello");

        String name1 = "Hello World";

        System.out.println(name);
        System.out.println(name1);

        // char inputs
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a char: ");
        char c = sc.next().charAt(0);

        System.out.print(c);
    }
}
