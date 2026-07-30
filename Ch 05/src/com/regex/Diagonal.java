package com.regex;

public class Diagonal {
    public static void main(String[] args) {

        int n = 5;
        for (int i = 1; i<=n;i++){
            for (int j = i; j < n;j++){
                System.out.print("_");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print("_");
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = n; j > i; j--) {
                System.out.print("_");
            }

            for (int j = 1; j <= (2 * i - 1); j++) {
                if (j == 1 || j == (2 * i - 1))
                    System.out.print("*");
                else
                    System.out.print("_");
            }
            System.out.println();
        }

        System.out.println();

        int arr[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        // right angle triangle :-
        for (int i = 0; i<arr.length;i++){
            for (int j = 0; j<= i;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        // opposite right angle triangle
        for (int i = 0; i<arr.length;i++){
            for (int j = 0; j < arr.length;j++){
                if (j < i) {
                    System.out.print("  ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

        // diagonal
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (i == j){
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // opposite diagonal
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i + j == arr.length - 1) {
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        // printing the middle element
        int mid = arr.length / 2;

        for (int i = 0; i<arr.length;i++){
            for (int j = 0; j< arr.length;j++){
                if (i == mid && j == mid) {
                    System.out.print(arr[i][j]);
                } else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

        // printing all the elements except the middle element
        int mid1 = arr.length / 2;

        for (int i = 0; i<arr.length;i++){
            for (int j = 0; j< arr.length;j++){
                if (i == mid1 && j == mid1) {
                    System.out.print("  ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
