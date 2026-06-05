import java.util.Scanner;

public class Pr4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the kilometers : ");
        double a = sc.nextDouble();

        double miles = a * 0.62137119;

        System.out.println("Miles = " + miles);
    }
}
