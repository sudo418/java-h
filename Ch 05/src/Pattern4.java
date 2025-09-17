import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = sc.nextInt();

        // triangle mirror image :-
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i + j > n) {
                    System.out.print("* ");
                }
                else System.out.print("  ");
            }
            System.out.println();
        }

        // another method of doing it better than above cuz in above you cant print number values
        // multiple loops inside loop
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // number triangle mirror image :-
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        // rhombus :-
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // star pyramid :-
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        // new method :-
        int nsp = n - 1, nst = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= nsp; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= nst; j++) {
                System.out.print("* ");
            }
            nsp--;
            nst += 2;
            System.out.println();
        }

        // same method for rhombus :-
        nsp = n - 1;
        nst = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= nsp; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= nst; j++) {
                System.out.print("* ");
            }
            nsp--;
            System.out.println();
        }

        // same method for triangle mirror image :-
        nsp = n- 1;
        nst = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= nsp; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= nst; j++) {
                System.out.print("* ");
            }
            nsp--;
            nst += 1;
            System.out.println();
        }

        // same method for triangle mirror image reverse :-
        nsp = 0;
        nst = n;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= nsp; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= nst; j++) {
                System.out.print("* ");
            }
            nsp++;
            nst--;
            System.out.println();
        }

        // Star diamond
        System.out.println("Star diamond");

        int nsp1 = n - 1, nst1 = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= nsp1; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= nst1; j++) {
                System.out.print("* ");
            }
            nsp1--;
            nst1 += 2;
            System.out.println();
        }
        nsp1 = 1; nst1 = 2 * n - 3;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= nsp1; j++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= nst1; j++) {
                System.out.print("* ");
            }
            nsp1++;
            nst1 -= 2;
            System.out.println();
        }
    }
}