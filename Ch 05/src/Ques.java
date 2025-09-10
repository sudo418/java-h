import java.util.Scanner;

public class Ques {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter n: ");
        int n = sc.nextInt();

        // All the factors of n
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                System.out.println(i);
        }

        // print the highest factor other than n itself
        int hf = 1;
        for (int i = 1; i < n; i++) {
            if (n % i == 0)
            {
                hf = i;
            }
        }
        System.out.println(hf);

        // more faster way of doing the same problem :-
        int hf1 = 1;
        for (int i = n - 1; i > 0; i--)
        {
            if (n % i == 0)
            {
                hf1 = i;
                break;
            }
        }
        System.out.println(hf1);

        // find if number is composite or not
        System.out.println("enter the number: ");
        int y = sc.nextInt();

        if (y == 1)
        {
            System.out.println("neither prime nor composite");
        }
        else {
            boolean flag = false;

            for (int i = 2; i < y; i++) {
                if (y % i == 0) {
                    System.out.println("composite");
                    flag = true;
                    break;
                }
            }

            if (flag == false) {
                System.out.println("prime");
            }
        }


    }
}
