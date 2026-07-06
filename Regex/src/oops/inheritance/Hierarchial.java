package oops.inheritance;

class Student1 {
    int a = 10;

    void attendance() {
        System.out.println("attendance is marked");
    }
}

class Engineer extends Student1 {
    int b = 20;
    void lab() {
        System.out.println("lab attendance is marked for engineering student");
    }
}

class Medical extends Student1 {
    int c = 30;
    void lab() {
        System.out.println("lab attendance is marked for medical student");
    }
}

public class Hierarchial {
    static void main() {
        Engineer e = new Engineer();
        e.attendance();
        e.lab();

        System.out.println();

        Medical m = new Medical();
        m.attendance();
        m.lab();


//        System.out.println(m.a + m.b + m.c);  --> error cuz m cannot access b cuz
//        Medical does not inherit Engineer it inherits Student so Medical cannot
//        access Engineer's fields (b) and methods (lab).
    }
}
