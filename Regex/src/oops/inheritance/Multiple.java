package oops.inheritance;

class X {
    void show() {
        System.out.println("X's show method");
    }
}

class Y {
    void show () {
        System.out.println("Y's show method");
    }
}
/*
class Z extends X, Y {   // ❌ not allowed in Java
    // if z.show() is called, which one runs — A's or B's?
}   */

public class Multiple {
    Multiple m = new Multiple();
}