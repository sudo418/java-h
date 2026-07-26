package com.practicequestion;

abstract class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("Bonus: " + calculateBonus());
    }

    abstract double calculateBonus();
}

class Developer extends Employee {
    Developer(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.10;
    }
}

class Manager extends Employee {
    Manager(int id, String name, double salary) {
        super(id, name, salary);
    }

    @Override
    double calculateBonus() {
        return salary * 0.20;
    }
}

public class Hellos2 {
    public static void main(String[] args) {
        Employee e1 = new Developer(101, "Aman", 50000);
        Employee e2 = new Manager(201, "Riya", 80000);

        e1.displayDetails();
        System.out.println("-------------------");
        e2.displayDetails();
    }
}
