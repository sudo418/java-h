package oops.inheritance;

class Student {
    String name;
    int age;

    void markAttendence() {
        System.out.println("Attendance is marked");
    }
}

class EngineeringStudent extends Student {
    void attendLab() {
        System.out.println("Lab attendance is marked");
    }
}

public class Simple {
    static void main() {
        EngineeringStudent es = new EngineeringStudent();

        es.markAttendence();
        es.attendLab();
    }
}
