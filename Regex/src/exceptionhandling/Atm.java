package exceptionhandling;

public class Atm {
    static int balance = 1000;

    static void checkBalance(int amount) {
        balance -= amount;
        if (balance >= 0) {
            System.out.println("current balance: " + balance);
        }
        else {
            throw new InsufficientFundException("Balance is insufficient", amount);
        }
    }
    static void main() {
        try {
            checkBalance(1005);
        }
        catch (InsufficientFundException e) {
            System.out.println(e.getMessage());
            System.out.println("Entered amount was: " + e.getAmount());
        }
    }
}
