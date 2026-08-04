package java8.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

class Employee {
    String name;
    double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("The name is: " + "Salary is: " + salary);
    }
}

public class ConsumerDemo {
    static void main() {

        Consumer<String> c = name -> System.out.println("My name is: " + name);
        c.accept("Hello");

        Consumer<Integer> c2 = n -> System.out.println("Square of given num is: " + n * n);
        c2.accept(3);

        Employee emp = new Employee("hello", 200);
        emp.display();
        Consumer<Employee> c3 = e1 -> e1.salary += 100;
        c3.accept(emp);
        emp.display();

        // ===========BiConsumer==============
        BiConsumer<Integer, Integer> bc = (n, m) -> System.out.println(n + m);
        bc.accept(1, 2);
    }
}
