import java.util.Scanner;

public class Pr02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the marks of phy: ");
        double phy = sc.nextDouble();

        System.out.print("Enter the marks of chem: ");
        double chem = sc.nextDouble();

        System.out.print("Enter the marks of mat: ");
        double mat = sc.nextDouble();

        double total = phy + chem + mat;
        double totalPercent = (total / 300) * 100;
        // double totalPercent = total/3;
        /* This is also correct, but it will not look good for interview and
        it decreases the readability */

        if (totalPercent > 40 && phy >= 33 && chem >= 33 && mat >= 33)
        {
            System.out.printf("You are pass with a percentage %.2f", totalPercent);
        }
        else
        {
            System.out.println("You are fail");
        }
        sc.close();
    }
}
