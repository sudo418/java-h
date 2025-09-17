import java.util.Scanner;

public class Patterns3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // floyd's triangle
        System.out.print("Enter the num: ");
        int n = sc.nextInt();

        int a = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + " ");
                a++;
                // System.out.println(a++ + " ");  another way of writing the above thing
            }
            System.out.println();
        }

        // print 0 and 1 triangle :-
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % 2 != 0) {
                    if (j % 2 != 0) {
                        System.out.print(1 + " ");
                    }
                    else {
                        System.out.print(0 + " ");
                    }
                }
                else {
                    if (j % 2 == 0) {
                        System.out.print(1 + " ") ;
                    }
                    else {
                        System.out.print(0 + " ");
                    }
                }
            }
            System.out.println();
        }

        // another logic for doing the same problem :-
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i % 2 != 0 && j % 2 != 0) || (i % 2 == 0 && j % 2 == 0)) {
                    System.out.print(1 + " ");
                }
                else System.out.print(0 + " ");
            }
            System.out.println();
        }
        
        // another logic of doing the same problem :-
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if ((i + j) % 2 == 0) System.out.print(1 + " ");
                else System.out.print(0 + " ");
            }
            System.out.println();
        }

        /*
        even + even = even
        odd + odd = even
        even + odd = odd
        In the code if i & j are even print 1 and if i & j are odd
        print 1 so its like if both are odd and both are even print 1.
        So if both are odd their sum = even and if both are even
        their sum = even. so in the code we are checking if their sum
        is even then print 1 else 0 */

        // Star plus
        int mid = (n + 1) / 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i == mid) || (j == mid)) {
                    System.out.print("* ");
                }
                else System.out.print("  "); // 2 spaces is compulsory in this
            }
            System.out.println();
        }

        // rectangle hollow pattern :-
        System.out.print("Enter the number of rows and columns: ");
        int rows = sc.nextInt();
        int col = sc.nextInt();

        for(int i = 1; i <= rows; i++) {
            for(int j = 1; j <= col; j++) {
                if (i == 1 || i == rows || j == 1 || j == col) {
                    System.out.print("* ");
                }
                else System.out.print("  ");
            }
            System.out.println();
        }

        // star cross (n is odd) :-
        for(int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if ((i == j) || (i + j == n + 1)) {
                    System.out.print("* ");
                }
                else System.out.print("  ");
            }
            System.out.println();
        }
    }
}
