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

        System.out.println(a);  // it will print 2.2 not 2 because :-
//      Here, only a is typecast to an int for this operation.
//      But this does not change the value of a itself a is still a float in memory.
//      The typecast applies only during the computation of sum

        System.out.print("The sum of 2 numbers is ");
        System.out.println(sum);

        System.out.println("Enter an int or float: ");
        boolean b1 = sc.hasNextInt();

        System.out.println(b1);

        sc.next();  // When we use two sc.next(); calls, the first one reads a word and skips over spaces and \n
        // automatically, so the second sc.next(); is ready to take actual user input.

        String str = sc.next();
        System.out.println(str);

        sc.nextLine();

        String str1 = sc.nextLine();
        System.out.println(str1);
    }
    // If we mix sc.next(); with sc.nextLine();, we get problems because:
    //sc.next(); leaves \n in the buffer.
    //sc.nextLine(); consumes the \n immediately, without waiting for actual input.
    
    //Example 2: Mixing sc.next(); with sc.nextLine();
    //sc.next();  // Reads a word but leaves '\n'
    //String str = sc.nextLine();  // Consumes only '\n' instead of waiting for input
    //System.out.println(str);
}
