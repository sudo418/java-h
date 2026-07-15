package exceptionhandling;

public class Throw {
    static void main() {
        int age = 18;

        if (age > 18) {
            System.out.println("you can vote");
        }
        else {
            System.err.println("you cannot vote");
        }

        checkEligibility(-5);
    }

    private static void checkEligibility(int a) {
        if (a < 0) {
            throw new IllegalArgumentException("age cannot be negative");
        }
        else if (a > 19) {
            System.out.println("not allowed to vote");
        }
        else {
            System.out.println("u can vote");
        }
    }
}
/*
 * ============================================================
 * WHY USE throw INSTEAD OF if-else? (Exception Handling Notes)
 * ============================================================
 *
 * SHORT ANSWER:
 * Yes, you CAN often replace a throw with an if-else. But they
 * solve different problems. if-else is for EXPECTED, NORMAL
 * branches in your logic. throw is for ABNORMAL situations that
 * break the normal flow -- cases where the method genuinely
 * cannot do its job and the CALLER needs to know something
 * went wrong.
 *
 * ANALOGY: Think of a bank ATM.
 * - "Insufficient funds - show message, return to menu"
 *      -> normal, expected case -> if-else
 * - "Someone ripped the card reader off the machine"
 *      -> not a normal case the ATM's daily logic should
 *         silently handle -> stop everything and alert the
 *         bank -> throw
 *
 * EXAMPLE COMPARISON:
 *
 * Using throw:
 *     if (a < 0) {
 *         throw new IllegalArgumentException("age cannot be negative");
 *     }
 *
 * Could be written as (just printing):
 *     if (a < 0) {
 *         System.out.println("invalid age");
 *         return;
 *     }
 *
 * But look at what's different between the two approaches:
 *
 * if-else (just printing):
 *   - Method quietly continues/returns as if nothing bad happened
 *   - Caller has no idea something went wrong (unless they read
 *     your printed message)
 *   - No information travels back up the call stack
 *   - Fine for expected results (like "not eligible to vote")
 *
 * throw:
 *   - Method stops immediately -- no code after it runs
 *   - Caller is FORCED to either catch it or let the program
 *     crash -- they can't ignore it
 *   - Carries an object with an error type + message + stack trace
 *   - Fine for cases that are NOT supposed to happen (like a
 *     negative age, which is invalid input, not a normal outcome)
 *
 * THE REAL REASON throw EXISTS:
 * In a big program, checkEligibility() might get called from ten
 * different places. If it just prints an error and returns, every
 * one of those ten callers has to remember to check "did it
 * actually work?" -- easy to forget, bugs slip through. With
 * throw, Java FORCES the problem to be dealt with somewhere up
 * the chain (via try-catch), so it can never be silently ignored.
 *
 * RULE OF THUMB FOR EXAMS:
 * - Use if-else for VALID ALTERNATIVE OUTCOMES
 *     e.g. "not allowed to vote" is a legitimate result of
 *     checking eligibility.
 * - Use throw for INVALID STATES/INPUTS that violate a method's
 *   assumptions
 *     e.g. "age cannot be negative" isn't a valid outcome at
 *     all -- it's bad data that shouldn't be processed further.
 *
 * That's exactly why in this code, age > 19 uses if-else (a
 * normal outcome) but a < 0 uses throw (an invalid input the
 * method refuses to work with).
 * ============================================================
 */