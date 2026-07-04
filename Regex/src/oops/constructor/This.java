package oops.constructor;
// 1) this is used in resolving naming conflicts
public class This {
    int a;
    int b;

    // Constructor — runs ONCE, automatically, at object creation
    // sets the object's initial/starting state
    This(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println(this);   // explanation written at the end of the code
    }

    // setData() — regular method, can be called ANY number of times, manually
    // used to modify/update the object's state after it's already created
    void setData(int a, int b) {
        this.a = a;
        this.b = b;
    }

    void showData() {
        System.out.println("a = " + a + " b = " + b);
    }

    public static void main() {
        This t = new This(5,2);
        t.showData();

        t.setData(10,20);
        t.showData();
    }
}
/*
'this' is used to resolve naming conflicts between instance variables
and parameters (both named 'name' here).
It is Java convention to name constructor/method parameters the same
as the instance variable they initialize — 'this' is what makes this
possible without ambiguity
*/
/*
System.out.println(this) implicitly calls toString() on the current object.
If toString() isn't overridden, Java's default Object.toString() returns the
class name and hashcode in the format ClassName@hexHashCode; if overridden,
it prints whatever custom format the class defines
*/