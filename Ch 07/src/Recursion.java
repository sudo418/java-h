import java.util.Scanner;

public class Recursion {

    static int fact(int a)
    {
        if(a == 0 || a == 1)
        {
            return 1;
        }
        else
        {
            return a * fact(a-1);
        }
    }

    static int fact_iterative(int a)
    {
        if(a == 0 || a == 1)
        {
            return 1;
        }
        else
        {
            int product = 1;
            for(int i = 1; i <= a; i++)
            {
                product *= i;
            }
            return product;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int a = sc.nextInt();

        if(a < 0)
        {
            System.out.println("Negative numbers don't have fact");
        }
        else
        {
            System.out.println(fact(a));
            System.out.println(fact_iterative(a));
        }
    }
}
