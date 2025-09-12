import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
//        int a = sc.nextInt();
        float a = sc.nextFloat();

        System.out.print("Enter second number: ");
//        int b = sc.nextInt();
        float b = sc.nextFloat();

        float sum = (int) a + b;

        System.out.println(a);  // it will print float not int because :-

        /*
        Here, only a is typecast to an int for this operation.
        (int) a + b → cast applies only to a.
        (int) (a + b) → cast applies to the entire sum
        Example: if a = 1.1 and b = 1.1
        (int) a = 1 → then 1 + 1.1 = 2.1 */

        /*
        But this does not change the value of a. a is still a float in
        memory. The typecast applies only during the computation of sum */

        System.out.print("The sum of 2 numbers is ");
        System.out.println(sum);

        System.out.println("Enter an int or float: ");
        boolean b1 = sc.hasNextInt();

        System.out.println(b1);

        sc.next();
        /*
        Q) what is this sc.next is doing here?

        ans) hasNextInt() on line 34 :- it only CHECKS the next token, it does
        NOT consume it.
        So if input is "22", the 22 is still there and the sc.next on line 54
        will read it.
        So that's why we called sc.next() on line 38 once to consume/discard the
        "22", then call sc.next() on line 54 again to read the following token.

        When we use two sc.next() calls, the first one
        reads a word and skips over spaces and \n automatically,
        so the second sc.next(); is ready to take actual user input.
        */

        String str = sc.next();
        System.out.println(str);

        sc.nextLine(); // why i added this answer in below comments

        String str1 = sc.nextLine();
        System.out.println(str1);
    }
}
    /*
    If we mix sc.next() with sc.nextLine(), we get problems because :-
    sc.next(); reads a word but leaves the newline '\n' in the buffer.
    sc.nextLine(); consumes the \n immediately, without waiting for actual
    input and gives you an empty string.
    */

    /*
    Example :- Mixing sc.next() with sc.nextLine()
    sc.next();  // Reads a word but leaves '\n'
    String str = sc.nextLine();  // Consumes only '\n' instead of waiting for input
    System.out.println(str);   // gives you an empty string
    */

    /*
    🔹 How to fix this issue :-
    sc.next();       // read a word
    sc.nextLine();   // consume leftover \n
    String line = sc.nextLine(); // now waits for actual input
    */

    /*
    mixing 2 sc.nextLine :-
    String s1 = sc.nextLine();
    String s2 = sc.nextLine();

    Q) why we didn't use 3 sc.nextLine?
    Ans) sc.nextLine() reads everything up to the newline and also consumes
    the newline itself.
    So the \n does not remain in the buffer after nextLine(). */