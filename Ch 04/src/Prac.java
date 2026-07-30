import java.util.Scanner;

public class Prac {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Operator: ");
        char ch = sc.next().charAt(0);

        System.out.print("Enter two nums: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        switch(ch) {
            case '+':
                System.out.println("Addition = " + (num1 + num2));
                break;
            case '-':
                System.out.println("Subtraction = " + (num1 - num2));
                break;
            case '*':
                System.out.println("Multiplication = " + (num1 * num2));
                break;
            case '/':
                System.out.println("Division = " + (num1 / num2));
                break;
            default:
                System.out.println("invalid input");
                break;
        }

        // q1)
        System.out.print("Enter a num: ");
        int num = sc.nextInt();

        switch (num % 2) {
            case 0:
                System.out.println(num + " is Even");
                break;
            case 1:
                System.out.println(num + " is Odd");
                break;
        }

        // q2
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        switch (age >= 18) {
            case true:
                System.out.println("You are eligible to Vote");
                break;
            case false:
                System.out.println("You are not eligible to Vote");
                break;
        }

        // q3
        System.out.print("Enter month number: ");
        int month = sc.nextInt();

        switch (month) {
            case 1:  System.out.println("January");   break;
            case 2:  System.out.println("February");  break;
            case 3:  System.out.println("March");     break;
            case 4:  System.out.println("April");     break;
            case 5:  System.out.println("May");       break;
            case 6:  System.out.println("June");      break;
            case 7:  System.out.println("July");      break;
            case 8:  System.out.println("August");    break;
            case 9:  System.out.println("September"); break;
            case 10: System.out.println("October");   break;
            case 11: System.out.println("November");  break;
            case 12: System.out.println("December");  break;
            default: System.out.println("Invalid month number");  break;
        }

        System.out.print("Enter Cost Price (CP):");
        int cp = sc.nextInt();
        System.out.print("Enter Selling Price (SP):");
        int sp = sc.nextInt();

        switch (sp > cp) {
            case true:
                System.out.println("Profit = " + (sp - cp));
                break;
            case false:
                System.out.println("Loss = " + (cp - sp));
                break;
        }

        /* without boolean support :-
        Approach 1 — Integer.signum()  :-
        int diff = sp - cp;

        switch (Integer.signum(diff)) {
            case 1:
                System.out.println("Profit = " + diff);
                break;
            case -1:
                System.out.println("Loss = " + (diff * -1));
                break;
            case 0:
                System.out.println("No Profit No Loss");
                break;
        }  */

        /*  Approach 2 — if-else  :-
        int result;
        if (sp > cp) {
            result = 1;
        } else if (sp < cp) {
            result = -1;
        } else {
            result = 0;
        }

        switch (result) {
            case 1:
                System.out.println("Profit = " + (sp - cp));
                break;
            case -1:
                System.out.println("Loss = " + (cp - sp));
                break;
            case 0:
                System.out.println("No Profit No Loss");
                break;
        }   */

        /*   Approach 3 — Ternary Operator
        int diff = sp - cp;

        switch (diff > 0 ? 1 : diff < 0 ? -1 : 0) {
            case 1:
                System.out.println("Profit = " + diff);
                break;
            case -1:
                System.out.println("Loss = " + (-diff));
                break;
            case 0:
                System.out.println("No Profit No Loss");
                break;
        }   */
    }
}
