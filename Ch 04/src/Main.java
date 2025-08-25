import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int age = 19;
        boolean cond = (age >= 18);

        if (cond) // if statements strictly require a boolean value
        {
        System.out.println("Yes you can drive");
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter you age: ");
        int age1 = sc.nextInt();

        if (age1 > 50)
        {
            System.out.println("You are mid age man");
        }
        else if (age1 > 13)
        {
            System.out.println("You are teen");
        }
        else if (age1 < 13)
        {
            System.out.println("You are a kid");
        }
    }
}