package com.practicequestion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryWithMultiCatch {
    static void main() {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[2];

        try {
            System.out.print("Enter the value of index 0: ");
            arr[0] = sc.nextInt();
            System.out.print("Enter the value at index 1: ");
            arr[1] = sc.nextInt();

            try {
                System.out.println("Enter the index value for numerator");
                int nIndex = sc.nextInt();
                int numerator = arr[nIndex];
                System.out.println("Enter the index value for denominator");
                int dIndex = sc.nextInt();
                int denominator = arr[dIndex];

                double result = (double)numerator / denominator;
                System.out.println(result);
            }
            catch (ArithmeticException e) {
                System.out.println("Cannot divide by 0");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Enter correct index value");
            }
            /*
            catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }   */
        }
        catch (InputMismatchException e) {
            System.out.println("Enter correct input");
        }
    }
}
