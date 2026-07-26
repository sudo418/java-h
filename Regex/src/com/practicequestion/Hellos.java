package com.practicequestion;

abstract class Vehicle11 {
    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped...");
    }
}

class Car11 extends Vehicle11 {
    @Override
    void start() {
        System.out.println("car started..");
    }
}

public class Hellos {
    public static void main(String[] args) {
        Vehicle11 v11 = new Car11();

        v11.start();
        v11.stop();
    }
}