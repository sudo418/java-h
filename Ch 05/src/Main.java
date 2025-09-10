public class Main {
    public static void main(String[] args) {

        int i = 1;
        while(i <= 5)
        {
            System.out.println(i);
            i++;
        }

        /* Infinite while loop  -->
        while (true)
        {
            System.out.println("I am an infinite while loop");
        } */

        /* Infinite for loop -->
        for(;;)
        {
            System.out.println("infinite for loop");
        } */

        /* In C/C++, boolean values can be 1 (true) or 0 (false).
        In C, any non-zero value is considered true, and only 0 is false
        In Java, boolean must be true or false — not 1 or 0. */

        int b = 10;

        do {
            System.out.println(b);
            b++;
        } while (b < 5);

        // Same program in while loop -->
        int c = 10;

        while (true)
        {
            System.out.println(c);
            if (c > 5)
            {
                break;
            }
        }
    }
}