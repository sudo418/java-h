import java.util.Scanner;

public class Patterns2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the num of rows and columns: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
            System.out.print((char)(64 + j) + " ");
            }
            System.out.println();
        }

        // print right angle triangle :-
        System.out.print("Enter the num of rows: ");
        int rows = sc.nextInt();

        for(int i = 1; i <= rows; i++)
        {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // print same but with digits
        for(int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // print abc triangle
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char)(j + 64) + " ");
            }
            System.out.println();
        }

        // alphanumeric pattern :-
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 == 0) {
                    System.out.print((char)(j + 64) + " ");
                }
                else {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }

        // Star triangle ulta :-
        for(int i = rows; i > 0; i--) {
            for(int j = 1; j <= i; j++)
            {
                System.out.print("* ");
            }
            System.out.println();
        }

        // another method of doing the above problem :-
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows + 1 - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        // (j <= rows + 1 - i) == (j + i <= rows + 1) both conditions are same

        // print 123 ula triangle
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j + i <= rows + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // print abc ulta :-
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows + 1 - i; j++) {
                System.out.print((char)(j + 64));
            }
            System.out.println();
        }

        // odd number triangle :-
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(2 * j - 1 + " ");
            }
            System.out.println();
        }

        // another method of doing the same problem :-
        for (int i = 1; i <= rows; i++) {
            int a = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");
                a += 2;
            }
            System.out.println();
        }
    }
}
