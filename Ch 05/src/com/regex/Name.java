package com.regex;

public class Name {
    public static void main(String[] args) {
        int n = 5;

        // C
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

        // H
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n-1 || i == (n-1)/2 || j == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        // I
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n-1 || j == (n-1)/2 || i == 0) {
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        // R
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

        // A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j == 0 || j == n - 1) && i > 0 || (i == 0 && j > 0 && j < n - 1) || i == (n - 1) / 2) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        // Y
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == j && i <= n / 2) ||
                        (i + j == n - 1 && i <= n / 2) ||
                        (j == n / 2 && i >= n / 2)){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        System.out.println();

        // U
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((j == 0 && i < n - 1) ||
                        (j == n - 1 && i < n - 1) ||
                        (i == n - 1 && j > 0 && j < n - 1)){
                    System.out.print("* ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }
}
