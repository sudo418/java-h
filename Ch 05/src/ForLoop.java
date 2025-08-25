public class ForLoop {
    public static void main(String[] args) {

        int i = 6;  // Declare 'i'

        /* for (i; i < 90; i++) --> not allowed in java
        whereas it is allowed in c */

        /*
        for (int i = 0; i < 5; i++) Tries to declare 'i'
        again in the same method scope — not allowed */

        for (i = 0; i < 6; i++)  // Reuse the same 'i' — no new declaration, just assignment
        {
            System.out.println(i);
        }

        // What is allowed -->
        int a = 1;       // 1

        for (; a <= 5; a++)
        {
            System.out.println(a);
        }

        int z;           // 2

        for (z = 0; z < 3; z++)
        {
            System.out.println(z);
        }


        for (int b = 0; b < 4; b++)       // 3
            System.out.println(b);
        /* the {} braces are not required in Java (or C) if the for
        loop has only one statement */

        for(int n = 0; n < 20; n++)
        {
            if (n % 2 != 0)
            {
                System.out.println(n);
            }
        }

        // Code for generating first n odd numbers
        for (int t = 0; t < 5; t++)
        {
            System.out.println(2*t + 1);
        }

        // Code for generating first n odd numbers
        for (int e = 0; e < 5; e++)
        {
            System.out.println(2*e);
        }
    }
}
