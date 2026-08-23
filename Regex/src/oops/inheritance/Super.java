package oops.inheritance;

class Animal {
    String color = "white";
    int age = 10;

    Animal(String color, int age) {
        this.color = color;
        this.age = age;
        System.out.println("Animal created");
    }

    void print() {
        System.out.println(color + " " + age);
    }
}

class Dog extends Animal {
    String color = "black";
    String name;

    // 3) super() to call parent's constructor
    Dog(String color,String name, int age) {
        super(color, age);  // calls Animal's constructor
        this.name = name;
        System.out.println("Dog created");
    }

    // 1) super to access parent's variable
    void printColor() {
        System.out.println(color);        // Black (child's own)
        System.out.println(super.color);  // White (parent's)

        System.out.println("age = " + age);   // if no same variable in child class then we can direct access it. in color case there are 2 colors so jvm confuses about which color
    }

    // 2. super to call parent's method
    void print() {
        super.print();     // calls parent's version first
    }
}

public class Super {
    static void main() {
        Dog d = new Dog("doggy","pink", 33);

        d.print();
    }
}
/*
In line 23 if u don't write that constructor there will be error --
error: constructor Animal in class Animal cannot be applied to given types;
implicit super constructor Animal() is undefined for default constructor
cuz
- Animal has a constructor with 2 params (color, age), so java doesn't
  give it a free no-arg constructor anymore
- Dog has no constructor of its own written -> java auto inserts a
  default Dog() constructor, which internally calls super() (no-arg)
- but Animal() with 0 args doesn't exist -> compiler error
- fix 1: write Dog's own constructor and manually call super(color, age)
  matching Animal's actual constructor
- fix 2: add a no-arg constructor Animal() { } in Animal class itself,
  then even Dog's auto-inserted super() will find something to call

why java calls super() internally on its own:
- every child object contains its parent's part inside it, and that
  part MUST be initialized before the child's own part is built
- so java guarantees this order automatically -> if a constructor
  doesn't explicitly call this() or super(), java silently inserts
  super() as the first line for u
- this way, even a careless/forgetful programmer can't accidentally
  create a child object with an uninitialized parent part
- it only fails when that auto-inserted super() has nothing to call
  (i.e. parent has no no-arg constructor available), which is exactly
  what happened here
*/