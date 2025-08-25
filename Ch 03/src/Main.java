public class Main {
    public static void main(String[] args) {

        // Strings are immutable and cannot be changed
        // Strings can be instantiated in java by 2 methods :-

        String name = new String("Hello");

        String name1 = "Hello World";

        System.out.println(name);
        System.out.println(name1);

        int a = 5;
        float b = 7.545f;

        System.out.printf("The value of a is %d and the value of b is %f\n", a, b);
        System.out.printf("The value of a is %d and the value of b is %.2f\n", a, b);
        System.out.printf("The value of a is %d and the value of b is %6.2f\n", a, b);
        System.out.format("The value of a is %d and the value of b is %f", a, b);
        // Both System.out.printf and System.out.format have the same use

        // 6.2f explained :- 7.55 has: 4 characters in total: 7, ., 5, 5
        // Java adds 2 spaces in front to make it right-aligned within 6 characters.
    }
}
