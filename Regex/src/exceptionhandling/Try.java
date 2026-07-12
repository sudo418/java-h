package exceptionhandling;

public class Try {
    static void main() {
        System.out.println("Source");

        try {
            int a = 5 / 0;    // illegal --> new ArithmeticException("/ by zero")
            // JVM detects the error, creates an ArithmeticException object,
            // and throws it right here -> control jumps straight to catch block
        }
        catch (ArithmeticException e) {
            System.out.println(e);
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("Division by 0 is not allowed");
        }
        // program does NOT crash here, because the exception was caught
        // -> flow continues normally after the try-catch block


        System.out.println("Destination");

        // ---------- String to int conversion ----------
        String value = "5";
        String value2 = "6";

        int v = Integer.parseInt(value);
        int v2 = Integer.parseInt(value2);

        System.out.println(v + v2);

        // ---------- Int to String conversion ----------
        int n = 7;
        Integer n2 = 8;    // autoboxing -> primitive int 8 automatically wrapped into Integer object

        String num = Integer.toString(n);
        String num2 = Integer.toString(n2);

        System.out.println(num + num2);

        // ---------- NumberFormatException ----------
        String x = "abc123";

        int z = Integer.parseInt(x);
        System.out.println(z);
    }
}
/*
IMPORTANT POINTS

1. e vs e.printStackTrace():
System.out.println(e)
- calls e.toString() internally
- prints just ONE line: exception class name + message
- goes to the normal output stream (System.out / stdout)
- output: java.lang.ArithmeticException: / by zero

e.printStackTrace()
- prints exception type + message, PLUS the entire call stack
  (which method, which line, all the way to main)
- goes to a DIFFERENT stream — System.err (error stream), not System.out
- output: shown in red, e.g.
  java.lang.ArithmeticException: / by zero
      at exceptionhandling.Try.main(Try.java:8)

Why the red stack trace appears at the BOTTOM, out of order
- even though it's called right after println(e) in the code,
  System.out and System.err are TWO SEPARATE streams
- IDEs (like IntelliJ) buffer/flush them independently, so System.err
  output (red text) can appear delayed/out of order compared to
  System.out, even though it technically ran earlier

2. autoboxing: Integer n2 = 8; -> autoboxing happens only here, since
   n2 is declared as Integer (wrapper/object type), so java automatically
   wraps the primitive 8 into an Integer object. this is NOT automatic
   for every int -> a plain "int" variable stays primitive and is never
   boxed; boxing only triggers when a primitive is needed as an object
   (wrapper variable, or collections like ArrayList<Integer>)

3. NumberFormatException:
   - occurs when Integer.parseInt() is given a String that isn't a
     valid number (e.g. "abc123")
   - this part has NO try-catch around it, so unlike the division
     example above, this WILL crash the program and stop execution
     at this line
*/