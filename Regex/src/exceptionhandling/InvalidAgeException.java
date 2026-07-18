package exceptionhandling;

public class InvalidAgeException extends RuntimeException{
    public InvalidAgeException(String message) {
        super(message);
    }
}
/*
 * WHY extends RuntimeException (and not extends Exception)?
 * ------------------------------------------------------------
 * extending RuntimeException -> makes this an UNCHECKED exception.
 *   - Compiler does NOT force you to catch it or declare "throws".
 *   - You can throw it anywhere freely, like a normal error signal.
 *
 * If we instead wrote:
 *     public class InvalidAgeException extends Exception
 * -> this would make it a CHECKED exception.
 *
 * This is NOT wrong by itself, and it does NOT cause an error on
 * its own. The class would compile fine either way.
 *
 * The error only shows up LATER, at the place where you actually
 * THROW this exception. Since it's now checked, the compiler will
 * force whichever method throws it to either:
 *   (a) wrap it in try-catch, OR
 *   (b) declare "throws InvalidAgeException" in its own signature
 * If you do neither, THAT line gives a compile-time error
 * ("unreported exception, must be caught or declared to be thrown").
 */

/*
 * WHY the constructor is PUBLIC:
 * ------------------------------------------------------------
 * - This exception needs to be thrown from OTHER classes too
 *   (e.g. Vote class throws it inside checkAge()).
 * - If the constructor were private/default (package-only) or
 *   protected, only code inside this exact class (or same
 *   package, for default) could create an object of it using
 *   "new InvalidAgeException(...)".
 * - Since we want ANY class, in ANY package, to be able to
 *   throw this exception when the "invalid age" condition
 *   happens, the constructor MUST be public -- so it's
 *   accessible everywhere the exception needs to be used.
 */