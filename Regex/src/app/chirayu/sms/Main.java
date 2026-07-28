package app.chirayu.sms;

import java.util.Scanner;

public class Main {
    static void main() {

        StudentService service = new StudentService();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n----- Student Management -----");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Search");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> service.addStudent();
                case 2 -> service.viewStudent();
                case 3 -> service.searchStudent();
                case 4 -> service.updateStudent();
                case 5 -> service.deleteStudent();
                case 6 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }
}
