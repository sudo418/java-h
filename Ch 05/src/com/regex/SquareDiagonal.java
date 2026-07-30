package com.regex;

public class SquareDiagonal {
    public static void main(String[] args) {
        int n = 5;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n-1 || j == 0 || i == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0 || i == (n-1) && j > 0 || j == 0 && i > 0 && i < (n-1)) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n-1 || j == 0 || i == 0 || i == (n-1)/2){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j == 0 || j == n - 1) && i > 0 || (i == 0 && j > 0 && j < n - 1) || i == (n - 1) / 2){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n-1 || j == 0 || i == j) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || j == n - 1 || (i == j && i <= n / 2) || (i + j == n - 1 && i <= n / 2)) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j == 0 ||
                        (i == 0 && j < n - 1) ||
                        (i == n - 1 && j < n - 1) ||
                        (j == n - 1 && i > 0 && i < n - 1)) {

                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }

            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j == 0 ||
                        (i == 0 && j < n - 1) ||
                        (i == (n - 1) / 2 && j < n - 1) ||
                        (j == n - 1 && i > 0 && i < (n - 1) / 2) ||
                        (i == j && i >= (n - 1) / 2)) {

                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (j == 0 ||
                        (i == 0 && j < n - 1) ||
                        (i == (n - 1) / 2 && j < n - 1) ||
                        (j == n - 1 && i > 0 && i < (n - 1) / 2) ||
                        (i == j && i >= (n - 1) / 2)) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        int size = 2 * n - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                // Square boundary
                if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
                    System.out.print("*");
                }
                // Diamond boundary
                else if (Math.abs(i - (n - 1)) + Math.abs(j - (n - 1)) == n - 1) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // Upper half
        for (int i = 1; i <= n; i++) {
            for (int j = i; j < n; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        // Lower half
        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = 1; i<=n;i++){
            for (int j = i; j < n;j++){
                System.out.print("_");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print("_");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
