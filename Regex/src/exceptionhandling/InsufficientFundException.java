package exceptionhandling;

public class InsufficientFundException extends RuntimeException{

    private int amount;

    public InsufficientFundException(String message, int amount) {
        super(message);
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
/*
 * WHY add extra fields (like "amount") in a custom exception:
 * ------------------------------------------------------------
 * - A normal exception only carries a message string -- useful
 *   for a human-readable description, but that's it.
 *
 * - Here we add "amount" as an extra field to carry MORE
 *   USEFUL DATA along with the exception, not just a message.
 *   So instead of just knowing "insufficient funds", the catch
 *   block can also know EXACTLY how much was short/involved.
 */