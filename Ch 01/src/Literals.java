public class Literals {
    public static void main(String[] args) {
        System.out.println("Literals");

        byte a = 127;
        short b = 4444;
        int c = 555555555;
        long d = 55555555555555555L;
        float e = 0.333f;
        double f = 5.555555555555;
        char ch = 'A';
        boolean g = true;
        String str = "Avi";

        System.out.println(d);
        System.out.println(str);
        System.out.println(f);

        int x = 5;
        float y = 7.545f;

        System.out.printf("The value of a is %d and the value of b is %f\n", x, y);
        System.out.printf("The value of a is %d and the value of b is %.2f\n", x, y);
        System.out.printf("The value of a is %d and the value of b is %6.2f\n", x, y);
        System.out.format("The value of a is %d and the value of b is %f", x, y);
        // Both System.out.printf and System.out.format have the same use

        /* 6.2f explained :- 7.55 has: 4 characters in total: 7, ., 5, 5
        Java adds 2 spaces in front to make it right-aligned within 6 characters. */
    }
}
