import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("0 = Rock\n1 = Paper\n2 = Scissor");

        System.out.print("Enter the thing you picked: ");
        int move = sc.nextInt();

        Random rand = new Random();
        int rand1 = rand.nextInt(3); // 3 is excluded

        if (move == rand1)
        {
            System.out.println("Tie");
        }
        else if (move >= 3)
        {
            System.out.println("Invalid choice");
        }
        else if ((move == 0 && rand1 == 2) ||
                 (move == 1 && rand1 == 0) ||
                 (move == 2 && rand1 == 1))
        {
            System.out.println("You Win");
            System.out.println("Computer picked: " + rand1 + "\tYou choose: " + move);
        }
        else
        {
            System.out.println("Computer Win");
            System.out.println("Computer picked: " + rand1 + "\tYou choose: " + move);
        }
    }
}