package app.chirayu.sms;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    ArrayList<Student> list = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addStudent() {
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        Student s = new Student(id, name);
        list.add(s);
        System.out.println("Student added successfully!");
    }

    void viewStudent() {
        if (list.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : list) {
            System.out.println(s);
        }
    }

    void searchStudent() {
        System.out.print("Enter id to search: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println("Student found!");
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    void updateStudent() {
        System.out.print("Enter id to update: ");
        int id = sc.nextInt();
        sc.nextLine();  // Consume the leftover newline

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.print("Enter new name: ");
                String name = sc.nextLine();

                s.setName(name);
                System.out.println("Name updated successfully!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        for (Student s : list) {
            if (s.getId() == id) {
                list.remove(s);
                System.out.println("Student deleted successfully");
                return;
            }
        }
    }
}
