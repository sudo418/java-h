import java.util.Scanner;

public class Patterns {
    public static void main(String[] args) {

        // print reverse of a given number
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the num: ");
        int num = sc.nextInt();

        int rev = 0;

        while (num != 0)
        {
            int lastdigit = num % 10;
            rev *= 10;
            rev += lastdigit;
            num /= 10;
        }
        System.out.println(rev);

        // factorial of a num :-
        System.out.println("fact of a number");

        System.out.print("Enter the num: ");
        int n = sc.nextInt();
        int fact = 1;

        for(int i = 1; i <= n; i++)
        {
            //fact *= i;
             fact *= i;
            System.out.println(fact);
        }
        System.out.println(fact);

        // print ascii values of all alphabets
        for(int i = 65; i <= 90; i++)
        {
            System.out.println(i + " " +(char)i);
        }
        /* System.out.println(i + (char)i);
        will give error cuz in arithmetic, a char is
        promoted to int so both operands are numeric types
        so it will add 65 + 65 = 130 */

        // pattern printing
        System.out.print("Enter the no. of rows & columns: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        for (int i = 1; i <= x; i++) // no of rows
        {
            for (int j = 1; j <= y; j++) {  // no of columns or you can say how many items are there in that row
                System.out.print("* ");
            }
            System.out.println();  // enter
        }

        // program to print solid square
        System.out.print("Enter the number of rows: ");
        int z = sc.nextInt();

        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= z; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // print 1234 number square
        System.out.print("Enter the num: ");
        int e = sc.nextInt();
        for (int i = 1; i <= e; i++) {
            for (int j = 1; j <= e; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}