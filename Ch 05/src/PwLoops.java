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
    }
}
