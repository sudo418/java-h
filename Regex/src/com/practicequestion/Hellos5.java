package com.practicequestion;

abstract class Shape {
    abstract double calculateArea();

    void display() {
        System.out.println("Area = " + calculateArea());
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length, breadth;

    Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    double calculateArea() {
        return length * breadth;
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class Hellos5 {
    public static void main(String[] args) {
        Shape s;

        s = new Circle(5);
        s.display();

        s = new Rectangle(4, 6);
        s.display();

        s = new Triangle(3, 8);
        s.display();
    }
}
