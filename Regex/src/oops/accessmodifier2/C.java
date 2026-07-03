package oops.accessmodifier2;
import oops.accessmodifier.A;

public class C {
    public static void main(String[] args) {
        A a3 = new A();

        // System.out.println(a3.a);
        // 'a' is default access, so it's only accessible within the same package

        System.out.println(a3.b);

        // System.out.println(a3.c);
        // 'c' is private, so it can only be accessed within the same class
    }
}
