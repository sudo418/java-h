package oops.polymorphism;

class A{
    int a = 10;

    void show(){
        System.out.println("a = " + a);
    }

    static void display() {
        System.out.println("Parent");
    }
}

class B extends oops.polymorphism.A {
    int a = 100;

    void show(){
        System.out.println("a = " + a);
    }

    static void display() {
        System.out.println("Child");
    }
}

public class ParentChild {
    public static void main(String[] args) {
        oops.polymorphism.B b1 = new oops.polymorphism.B();
        System.out.println(b1.a);

        oops.polymorphism.A a11 =  new oops.polymorphism.B();
        System.out.println(a11.a);  // variables don't override

        a11.show();       // Calls B.show()
        a11.display();   // Calls A.Display()
    }
}
/*
 * Upcasting:
 * Assigning a Child object to a Parent reference.
 * Syntax:
 * Parent p = new Child();
 *
 * A Parent reference can refer to a Child object because
 * a Child inherits all the members of the Parent class.
 *
 * During upcasting, the Parent reference can access only
 * the members available in the Parent class, even though
 * the actual object is of the Child class.
 */

/*
 * Parent p = new Child();
 *
 *                 Child Object
 *
 *      +---------------------------+
 *      | Parent Part               |  <-- Visible through p
 *      | (Inherited Members)       |
 *      +---------------------------+
 *      | Child Part                |  <-- Hidden from p
 *      | (Child-specific Members)  |
 *      +---------------------------+
 *
 * A Parent reference points to a Child object, but it can access
 * only the Parent part because the reference type is Parent.
 *
 * Therefore:
 * Parent p = new Child();   // ✔ Valid (Upcasting)
 */

/*
 * Q. Why does p.show() call Parent.show() even though
 * the object is Child?
 *
 * Answer:
 *
 * Static methods DO NOT belong to the object.
 * They belong to the CLASS.
 *
 *                  p
 *                  │
 *                  ▼
 *             Child Object
 *
 *      +---------------------------+
 *      | Parent Part               |
 *      +---------------------------+
 *      | Child Part                |
 *      +---------------------------+
 *
 *      ↑ No static methods are inside the object.
 *
 *
 * Parent Class                  Child Class
 * +-------------------+         +-------------------+
 * | static show()     |         | static show()     |
 * +-------------------+         +-------------------+
 *
 * Notice:
 * Both methods exist separately.
 * Child does NOT replace Parent's static method.
 *
 * Now Java asks:
 *
 * "Which class should I use?"
 *
 * Java cannot look at the object because
 * static methods are NOT stored inside objects.
 *
 * The only information Java has is the reference type.
 *
 * Parent p = new Child();
 * ^^^^^^
 * Reference Type = Parent
 *
 * So Java says:
 *
 * "Use the Parent class."
 *
 * Therefore, it executes:
 * Parent.show();
 *
 * Think of the reference as a label:
 *
 *        Parent p = new Child();
 *        ^^^^^^
 *        "I am a Parent reference."
 *
 * Since static methods belong to classes,
 * Java follows the reference label and
 * calls Parent.show().
 *
 * One tiny correction to your understanding: Earlier we said
 * "Java has only the reference." That's not literally true—the
 * JVM also knows the object is a Child. The real reason is
 * Java intentionally ignores the object for static methods,
 * because static methods are defined to belong to the class, not
 * the object. That's why it uses the reference type instead.
 */

/*
 * Why is Child c = new Parent(); not allowed?
 *
 * A Parent object does not contain Child-specific members.
 * If Java allowed it, we could access Child members that
 * do not exist in the Parent object, leading to errors.
 *
 * Therefore:
 * Parent p = new Child();  // ✔ Valid
 * Child c = new Parent();  // ✘ Invalid
 */

/*
 * Q. Why is Child c = new Parent(); not allowed?
 *
 * Answer:
 *
 * A reference can only point to an object that
 * actually contains everything the reference expects.
 *
 * A Child reference expects a Child object.
 *
 * Child Reference
 *        │
 *        ▼
 * Expects:
 *
 * +----------------------+
 * | Parent Part          |
 * +----------------------+
 * | Child Part           |
 * +----------------------+
 *
 * But a Parent object contains only:
 *
 * +----------------------+
 * | Parent Part          |
 * +----------------------+
 *
 * There is NO Child part.
 *
 * Now consider:
 *
 * Child c = new Parent();
 *
 * Java asks:
 *
 * "Can this Parent object satisfy a Child reference?"
 *
 * Answer:
 *
 * NO.
 *
 * Because the Child reference expects both
 * the Parent part and the Child part,
 * but the Parent object has only the Parent part.
 *
 * Imagine Java allowed this:
 *
 * Child c = new Parent();
 *
 * c.childMethod();
 *
 * Where would childMethod() come from?
 *
 * The Parent object doesn't have it.
 *
 * Java prevents this impossible situation by giving
 * a compile-time error:
 *
 * "Incompatible types:
 * Parent cannot be converted to Child."
 */