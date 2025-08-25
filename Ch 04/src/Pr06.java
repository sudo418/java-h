import java.util.Scanner;

public class Pr06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the name of the website: ");
        String website = sc.next();

        if(website.endsWith(".org"))
        {
            System.out.println("Organisational website");
        }
        else if(website.endsWith(".com"))
        {
            System.out.println("Commercial website");
        }
        else if(website.endsWith(".in"))
        {
            System.out.println("Indian website");
        }
        else
        {
            System.out.println("Invalid Domain name");
        }
    }
}
