package exceptionhandling;

public class Finally {
    static void main() {

        // ---------- basic try-catch-finally ----------
        try {
            System.out.println(5 / 0);        // risky code -> throws ArithmeticException here

            System.out.println("Hello");      // never printed -> once exception is thrown,
                                              // remaining lines in try block are SKIPPED,
                                              // control jumps straight to catch
        }
        catch (ArithmeticException e) {
            System.out.println("Division by 0 is not allowed");    // handling/preventive code
        }
        finally {
            System.out.println("Hello");    // cleanup code
        }


        /*
        // ---------- catching the WRONG exception type ----------
        try {
            System.out.println(2 / 0);    // this actually throws ArithmeticException
        }
        catch(NullPointerException e) {
            // this catch does NOT match ArithmeticException
            System.out.println("Null pointer exception");
        }
        // since no catch matched, this would actually CRASH the
        // program right here (uncaught ArithmeticException) ->
        // program terminates, nothing after this point runs
        */

        // ---------- multiple catch blocks ----------
        try {
            System.out.println(3 / 0);
        }
        catch (ArithmeticException e) {
            System.out.println("Dividing by 0 is not allowed");
        }
        catch (NullPointerException e) {
            System.out.println("Nulls not allowed");
        }
        // java checks catch blocks TOP TO BOTTOM, uses the FIRST
        // matching one, then skips the rest entirely


        // ---------- new way for multiple catch (multi-catch, Java 7+) ----------
        int arr[] = {10, 20, 30, 40, 50};

        try {
            System.out.println(arr[5] / 0);
            // arr[5] throws ArrayIndexOutOfBoundsException first.
            // Once an exception occurs, the rest of the statement (/ 0) is not executed.
        }
        catch (ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }


        // ---------- try without catch, only finally ----------
        try {
            System.out.println(7 / 0);
        }
        finally {
            System.out.println("Hello World");
            // -> program crashes right after printing "Hello World",
            // nothing after this try-finally block would execute
        }
    }
}
/*
IMPORTANT POINTS

1. finally block ALWAYS executes, whether exception occurs or not,
   whether it's caught or not -> meant for cleanup code (closing
   files, closing db connections, releasing resources, logging) not for handling logic

2. multi-catch (Java 7+): catch (TypeA | TypeB e) lets one catch
   block handle multiple exception types together, reduces duplicate
   code, but the caught types must not have a parent-child relationship
   with each other

3. try WITHOUT catch (only finally) is valid syntax -> finally still
   runs, but since nothing actually catches the exception, it gets
   re-thrown after finally finishes, and the program still crashes
*/