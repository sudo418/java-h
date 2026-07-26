package com.practicequestion;

interface Animal {
    void sound();
}

class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("Woof Woof");
    }
}

class Cat implements Animal {
    @Override
    public void sound() {
        System.out.println("Meow Meow");
    }
}

public class Hellos4 {
    public static void main(String[] args) {
        Animal a;

        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();
    }
}
