package oops.constructor;
// 3) this is used to pass the current object as an argument
class Hellow {
    String name;

    void show(Hellow h) {          // takes object as parameter
        System.out.println(h.name);
    }

    void display() {
        show(this);   // passing current object to another method
    }
}

public class This3 {
    static void main() {
        Hellow h = new Hellow();
        h.name = "Rahul";

        h.display();
    }
}
