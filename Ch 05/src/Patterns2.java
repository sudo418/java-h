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

        // print abc
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char)(j + 64) + " ");
            }
            System.out.println();
        }
    }
}
