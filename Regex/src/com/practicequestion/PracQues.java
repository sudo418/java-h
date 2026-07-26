package com.practicequestion;

import java.util.Scanner;

public class PracQues {
    static void main() {

        Scanner sc = new Scanner(System.in);

//        // q1   there also another method in which the digit will print in same order
//        System.out.print("Enter a num: ");
//        int num = sc.nextInt();
//
//        while (num != 0){
//            int rem = num % 10;
//            System.out.println(rem);
//            num /= 10;
//        }
//
//        // q2    // java forces u to assign value for local variable
//        System.out.print("Enter a num: ");
//        int num1 = sc.nextInt();
//        int sum = 0, digit;
//
//        while (num1 != 0) {
//            digit = num1 % 10;
//            sum += digit;
//            num1 /= 10;
//        }
//        System.out.println(sum);
//
//        // q3
//        System.out.print("Enter a num: ");
//        int num2 = sc.nextInt();
//        int evensum = 0, oddsum = 0, digit1;
//
//        while (num2 != 0){
//            digit1 = num2 % 10;
//
//            if (digit1 % 2 == 0) {
//                evensum += digit1;
//            } else {
//                oddsum += digit1;
//            }
//            num2 /= 10;
//        }
//        System.out.println("Sum of even digits = " + evensum);
//        System.out.println("Sum of odd digits = " + oddsum);
//
//        // q4
//        System.out.print("Enter a number: ");
//        int n = sc.nextInt();
//
//        int sum4 = 0, digit4;
//
//        while (n != 0) {
//            digit4 = n % 10;
//
//            if (digit4 == 2 || digit4 == 3 || digit4 == 5 || digit4 == 7) {
//                sum4 += digit4;
//            }
//            n /= 10;
//        }
//
//        System.out.println("Sum of prime digits = " + sum4);

//        // q5
//        System.out.print("Enter a num: ");
//        int num = sc.nextInt();
//        int count = 0;
//
//        while (num != 0){
//            num /= 10;
//            count++;
//        }
//        System.out.print(count);

//        // q6
//        System.out.print("Enter a number: ");
//        int num = sc.nextInt();
//
//        int reverse = 0, digit;
//
//        while (num != 0) {
//            digit = num % 10;
//            reverse = reverse * 10 + digit;
//            num /= 10;
//        }
//
//        System.out.println("Reversed number = " + reverse);

        // q7
//        System.out.print("Enter a number: ");
//        int num = sc.nextInt();
//
//        int original = num;
//        int reverse = 0, digit;
//
//        while (num != 0) {
//            digit = num % 10;
//            reverse = reverse * 10 + digit;
//            num /= 10;
//        }
//
//        if (original == reverse) {
//            System.out.println("Palindrome Number");
//        } else {
//            System.out.println("Not a Palindrome Number");
//        }

//        // q8
//        System.out.print("Enter a number: ");
//        int num = sc.nextInt();
//
//        for (int i = 0; i <= 9; i++) {
//            int temp = num;
//            int count = 0;
//
//            while (temp != 0) {
//                int digit = temp % 10;
//
//                if (digit == i) {
//                    count++;
//                }
//
//                temp /= 10;
//            }
//
//            if (count > 0) {
//                System.out.println(i + " occurs " + count + " times");
//            }
//        }

        //q9
//        int num = sc.nextInt();
//        boolean isPrime = true;
//
//        if (num <= 1) {
//            isPrime = false;
//        } else {
//            for (int i = 2; i * i <= num; i++) {
//                if (num % i == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//        }
//
//        if (isPrime) {
//            System.out.println("Prime Number");
//        } else {
//            System.out.println("Not a Prime Number");
//        }

        //        System.out.println("Enter a number:");

//        int n = sc.nextInt();
//        boolean isPrime = true;
//
//        for (int i = 2; i < Math.sqrt(n); i++) {
//            if (n % i == 0) {
//                isPrime = false;
//                break;
//            }
//        }
//
//        if (isPrime && n > 1) {
//            System.out.println(n + " is Prime");
//        } else {
//            System.out.println(n + " is Not Prime");
//        }

        //q10
//        System.out.print("Enter a num: ");
//        int n = sc.nextInt();
//        int a,b,c;
//
//        a = n % 10;
//        b = (n/10) % 10;
//        c = (a+b) + (a*b);
//
//        System.out.println((c == n)? "its special 2 digit num" : "it's not special 2 digit num");

        // q11
//        int arr[] =  {100,200,300,400,500};
//        for (int left = 0, right = arr.length - 1; left < right; left++, right--) {
//            arr[left]  = arr[left] + arr[right];
//            arr[right] = arr[left] - arr[right];
//            arr[left]  = arr[left] - arr[right];
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
    }
}