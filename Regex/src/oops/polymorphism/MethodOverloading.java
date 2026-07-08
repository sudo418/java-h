/*
POLYMORPHISM has 2 types:
1. compile-time polymorphism -> method overloading
2. runtime polymorphism -> method overriding

method hiding is not a separate type of polymorphism, it's just kept
in this same polymorphism package because it's closely related/compared
to overriding (both look similar but hiding is for static methods,
resolved at compile-time based on reference type, not runtime)
*/

package oops.polymorphism;

class Human {
    void run(){
        System.out.println("2 km/hr");
    }

    void run(boolean isDog) {
        if (isDog) {     // or if (isDog == true)
            System.out.println("5 km/hr");
        }
        else {
            System.out.println("2 km/hr");
        }
    }
}

public class MethodOverloading {
    static void main() {
        Human h = new Human();

        h.run();
        h.run(true);
        h.run(false);

        boolean isDog = true;
        h.run(isDog);
    }
}
/*
Rule to remember
For method overloading, Java considers:

✅ Number of parameters
✅ Type of parameters
✅ Order of parameters

Java does not consider:

❌ Return type
❌ Method body
❌ Parameter names
❌ Access modifier

ex :-
1. Different Number of Parameters ✅
void add(int a, int b) { }
void add(int a, int b, int c) { }

2. Different Types of Parameters ✅
void add(int a, int b) { }
void add(double a, double b) { }

3. Different Order of Parameters ✅
void display(String name, int age) { }
void display(int age, String name) { }
 */
