import java.util.Scanner;

public class Pr2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the marks of first subject : ");
        int sub1 = sc.nextInt();

        System.out.print("Enter the marks of second subject : ");
        int sub2 = sc.nextInt();

        System.out.print("Enter the marks of third subject : ");
        int sub3 = sc.nextInt();

        int total = sub1 + sub2 + sub3;

        float percentage = (float)total /3;

    /* If total is an int, dividing it by 100 will perform integer
    division rather than producing a float or double result.
    Even though you're assigning it to a float, the calculation
    is performed as integer division.

    This is because the division operator (/) follows the type of its operands:

    If both operands are integers → result is an integer.
    If at least one operand is float or double → result is floating
    point */

    // float cgpa = percentage/9.5; --> wrong because see below

    /* By default, Java treats decimal literals (like 9.5) as double types.
    When you divide percentage (which is float) by 9.5 (which is double)
    the result of the operation is a double.

    Assigning a double result directly to a float variable causes a
    type mismatch because a float is smaller in precision than a double
    */

    // correct way to do this :-

        float cgpa = percentage/9.5f;

    // float cgpa = (float)percentage/9.5;
    // double cgpa = percentage/9.5;

        System.out.print("You got ");
        System.out.println(cgpa);
    }
}
