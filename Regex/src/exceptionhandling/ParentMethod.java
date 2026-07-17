package exceptionhandling;

public class ParentMethod {
    static void main() {
        // Exception handling in chain of methods
        System.out.println("Source");

        try {
            methodA(5 ,0);
        }
        catch (ArithmeticException e) {
            System.out.println("Division by 0 not allowed");
        }
    }

    private static void methodA(int a, int b) {
        methodB(a, b);
    }

    private static void methodB(int a, int b) {
        System.out.println(a/b);   // exception occurs here (ArithmeticException)

        System.out.println("Destination");  // NEVER printed, see explanation below
    }
}

class ParentMethod2 {
    static void main() {
        // Version 2: try-catch in methodB ITSELF -> "Destination" DOES get printed
        System.out.println("Source");

        methodA(5, 0);
    }

    private static void methodA(int a, int b) {
        methodB(a, b);
    }

    private static void methodB(int a, int b) {
        try {
            System.out.println(a/b);   // exception occurs here
        }
        catch (ArithmeticException e) {
            System.out.println("Division by 0 not allowed");
        }

        System.out.println("Destination");   // NOW this DOES get printed
    }
}
/*
WHY "Destination" IS NEVER PRINTED

call chain: main -> methodA -> methodB

1. "Source" gets printed first
2. main calls methodA, methodA calls methodB
3. inside methodB, a/b throws ArithmeticException right at that line
4. JVM immediately stops methodB's execution -> "Destination" line
   never runs, since it comes AFTER the line that threw the exception

5. JVM now searches for a matching catch block, starting from where
   the exception occurred and going DOWN the call stack:
   - checks methodB -> no try-catch here -> pop methodB off the stack
   - checks methodA -> no try-catch here -> pop methodA off the stack
   - checks main -> HAS a try-catch around methodA(5,0) -> MATCH FOUND

6. catch block in main runs -> prints "Division by 0 not allowed"
7. after catch block finishes, main itself finishes (nothing after
   try-catch) -> program ends

so "Destination" is skipped because the exception interrupts methodB
BEFORE that line executes, and once thrown, control never returns
back to methodB or methodA — it jumps straight to whichever method up
the call stack actually has a matching catch block (main, in this case)
*/