package oops.accessmodifier;

public class B {
    public static void main(String[] args) {
        A a2 = new A();

        System.out.println(a2.a);
        System.out.println(a2.b);
        // System.out.println(a2.c);   --> error
        // 'c' is private, so it can only be accessed within the same class
    }
}
