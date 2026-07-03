package oops.accessmodifier;

public class A {
    int a = 10;
    public int b = 20;
    private int c = 30;

    public static void main(String[] args) {
        A a1 = new A();

        System.out.println(a1.a);
        System.out.println(a1.b);
        System.out.println(a1.c);
        /*  a, b, c all are accessible here because this code
            is inside class A itself — access modifiers don't
            restrict access within the same class, regardless
            of private/public/default.  */
    }
}
