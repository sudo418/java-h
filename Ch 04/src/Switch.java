/*
--> A switch can occur within another switch(nested switch) but
it is rarely done.
--> Variable can be integer, character, string in switch
*/

import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Example 1 :-
        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        switch (age)
        {
            case 18:
                System.out.println("You are going to college");
                break;
            case 23:
                System.out.println("You are going to do a job");
                break;
            case 60:
                System.out.println("You are going to retire");
                break;
            default:
                System.out.println("Enjoy your life");
                break;
        }

        // Example 2 :-
        System.out.print("Enter a character: ");
        char ch = sc.next().charAt(0);

        switch (ch)
        {
            case 'c':
                System.out.println("You entered c");
                break;
            case 'd':
                System.out.println("You entered d");
                break;
            case 'e':
                System.out.println("You entered e");
                break;
            default:
                System.out.println("You entered an alphabet other than c, d, e");
                break;
        }

        // Example 3 :-
        String name = "avi";

        switch (name)
        {
            case "avi":
                System.out.println("Your name is avi");
                break;
            case "chirayu":
                System.out.println("Your name is chirayu");
                break;
            default:
                System.out.println("i don't know your name");
                break;
        }

        // Enhanced Switch

        switch (name)
        {
            case "avi" -> {
                        System.out.println("Your name is avi");
                        System.out.println("Your name is avi");
                        System.out.println("Your name is avi");
            }
            case "chirayu" -> System.out.println("Your name is chirayu");
            default -> System.out.println("i don't know your name");
        }

        /* Enhanced switch :-
        --> Can return values directly (like expressions)
        --> No need for 'break'

        Normal switch :-
        --> Cannot return values directly
        */

        String name1 = "chirayu";

        String message = switch (name1) {
            case "avi" -> "Your name is avi";
            case "chirayu" -> "Your name is chirayu";
            default -> "I don't know your name";
        };
        /*
        In the new switch :-
        If we use switch just to run code (statement), default is optional.
        If we use switch to return/assign a value (expression), default
        is compulsory unless all possible values are covered.

        --> In the above code we are assigning value of switch case to
        message that's why default is compulsory otherwise it will give error.
        --> In the code starting from line 72 default is not necessary coz
        it's just a statement switch is not returning value to some variable.
        Statement doesn’t have to produce a value → so compiler doesn’t care
        about exhaustiveness.
        */

        System.out.println(message);
    }
}