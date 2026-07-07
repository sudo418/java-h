package oops.association;

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Car {
    String model;

    Car(String model) {
        this.model = model;
    }

    void assignDriver(Driver driver) {
        System.out.println(driver.name + " drives " + model);
    }
}

public class Association {
    static void main() {
        Driver d = new Driver("Bob");
        Car c = new Car("audi");

        c.assignDriver(d);
    }
}
