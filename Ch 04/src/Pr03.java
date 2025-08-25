import java.util.Scanner;

public class Pr03 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the amount you earned: ");
        double amount = sc.nextDouble();
        double tax = 0;
        
        if (0 < amount && amount <= 250000)
        {
            tax = 0;    
        }
        else if (amount <= 500000 )
        {
            tax = (5.0/100) * (amount-250000);
        }
        else if (amount <= 1000000)
        {
            tax = (5.0/100) * 250000 + (20.0/100) * (amount-500000);
        }
        else if (amount > 1000000)
        {
            tax = (5.0/100) * 250000 + (20.0/100) * 500000 + (30.0/100) * (amount-1000000);
        }
        else
        {
            System.out.println("Invalid amount");
        }
        System.out.println(tax);
    }
}
