public class Pr05 {

    static int fib(int a)
    {
       /* if(a == 1)
        {
            return 0;
        }
        else if(a == 2)
        {
            return 1;
        } */

        // Another way of writing the same thing :-
        if(a == 1 || a == 2)
        {
            return a - 1;
        }
        else
        {
            return fib(a - 1) + fib(a - 2);
        }
    }

    static float temp(float c)
    {
        return c * 9/5 + (32);
    }

    public static void main(String[] args) {

        // Fibonacci Sequence = 0, 1, 1, 2, 3, 5, 8, 13, 21, 34

        int a = 5;
        int result = fib(a);
        System.out.println(fib(a));

        System.out.println(temp(32));
    }
}
