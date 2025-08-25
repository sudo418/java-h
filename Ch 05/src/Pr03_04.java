import java.util.Scanner;

public class Pr03_04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int n = sc.nextInt();

        System.out.println("The table of n :- ");

        for (int i = 0; i < 10; i++)
        {
            System.out.println(n + " x " + (i + 1) + " = " + n*(i+1));
        }

        System.out.println("Now in reverse order");

        for(int i = 10; i !=0; i--)
        {
            System.out.println(n + " x " + i + " = " + n*i);

        }

    }
}
