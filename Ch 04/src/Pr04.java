import java.util.Scanner;

public class Pr04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int num = sc.nextInt();

        String message = switch (num)
        {
            case 1 -> "Today is Monday";
            case 2 -> "Today is Tuesday";
            case 3 -> "Today is Wednesday";
            case 4 -> "Today is Thursday";
            case 5 -> "Today is Friday";
            case 6 -> "Today is Saturday";
            case 7 -> "Today is Sunday";
            default -> "Invalid input";
        };

        System.out.println(message);
    }
}
