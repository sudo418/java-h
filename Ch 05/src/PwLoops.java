import java.util.Scanner;

public class PwLoops {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number");
        int n = sc.nextInt();

        int sum = 0;

        while(n != 0)
        {
            int lastDigit = n%10;
            sum += lastDigit;
            n /= 10;
        }
        System.out.println(sum);

        /* for loop with update inside the loop condition
        for (; n > 0; n /= 10)
        {
            int lastDigit = n % 10;
            sum += lastDigit;
        }
        */

        // program to print first n odd numbers and their sum
        int n1 = 5;
        int sum1 = 0;

        for(int i = 0; i < n1; i++)
        {
            System.out.println(2 * i + 1);
            sum1 = sum1 + (2 * i + 1);
        }
        System.out.println(sum1);

        // program to print odd numbers between 0 and 10
        for (int i = 0; ; i++)
        {
            int odd = 2 * i + 1;
            if (odd > 10) break;
            System.out.println(odd);
        }

        // same program with diff method
        System.out.println("with diff method");
        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0)
            {
                System.out.println(i);
            }
        }
    }
}
