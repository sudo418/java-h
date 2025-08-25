import java.util.Scanner;

public class Pr05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a year you wanna check: ");
        short year = sc.nextShort();

        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            System.out.println("Year is a leap year");
        }
        else
        {
            System.out.println("Not a leap year");
        }
    }
}
