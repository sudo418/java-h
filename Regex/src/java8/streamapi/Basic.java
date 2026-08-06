package java8.streamapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;


// ==========================================================
// Functional Interface
// A functional interface contains only one abstract method.
// Such interfaces can be implemented using Lambda Expressions.
// ==========================================================
interface Car {

    void drive();
}


// ==========================================================
// Traditional way of implementing an interface using a class.
// ==========================================================
class Audi implements Car {

    @Override
    public void drive() {
        System.out.println("drive......");
    }
}


public class Basic {

    static void main() {

        // ==========================================================
        // Traditional Way
        // Create a class that implements the interface and then
        // create its object.
        // ==========================================================

        Audi a = new Audi();
        a.drive();



        // ==========================================================
        // Anonymous Class
        // Creates an object of an unnamed class that implements
        // the interface without creating a separate class file.
        // Useful when the implementation is required only once.
        // ==========================================================

        Car c = new Car() {
            @Override
            public void drive() {
                System.out.println("drive..");
            }
        };



        // ==========================================================
        // Lambda Expression
        // Since Car is a Functional Interface (only one abstract
        // method), its implementation can be written using a lambda.
        // This is shorter and more readable than an anonymous class.
        // ==========================================================

        Car c2 = () -> System.out.println("drive..");
        c2.drive();



        // ==========================================================
        // Consumer Functional Interface
        // Consumer accepts one input and returns nothing.
        //
        // Method:
        //      accept(T value)
        // ==========================================================

        Consumer<Integer> consumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };



        // ==========================================================
        // Lambda Expression for Consumer
        // Equivalent implementation of the anonymous Consumer class.
        // ==========================================================

        Consumer<Integer> consumer2 = x -> System.out.println(x);



        // ==========================================================
        // Creating a List
        // ==========================================================

        List<Integer> li = new ArrayList<>();

        li.add(6);
        li.add(5);
        li.add(66);
        li.add(8);
        li.add(10);

        System.out.println(li);



        // ==========================================================
        // forEach() accepts a Consumer.
        // Every element of the List is passed one by one to
        // consumer2.accept(element).
        // ==========================================================

        li.forEach(consumer2);



        // ==========================================================
        // Collections.sort() sorts the ORIGINAL List.
        // It modifies the existing data.
        // ==========================================================

        Collections.sort(li);

        System.out.println(li);



        // ==========================================================
        // Stream Motivation
        //
        // Collections.sort() changes the original collection.
        //
        // Streams allow us to process data without modifying the
        // original source collection.
        // ==========================================================

        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(7);
        list.add(57);
        list.add(2);

        System.out.println(list);



        // ==========================================================
        // Create a Stream from the List.
        // list.stream() returns a Stream object.
        // ==========================================================

        Stream<Integer> s = list.stream();



        // ==========================================================
        // sorted() returns a NEW Stream.
        // The original List remains unchanged.
        // ==========================================================

        Stream<Integer> sortedStream = s.sorted();



        // ==========================================================
        // forEach() is a Terminal Operation.
        // It starts processing the Stream and prints every element.
        // ==========================================================

        sortedStream.forEach(x -> System.out.println(x));



        // ==========================================================
        // Method Chaining
        // Multiple Stream operations can be written in a single
        // statement because every intermediate operation returns
        // another Stream.
        // ==========================================================

        list.stream()
                .sorted()
                .forEach(x -> System.out.println(x));



        // ==========================================================
        // The original List is still unchanged because Streams do
        // not modify their source collection.
        // ==========================================================

        System.out.println(list);



        // ==========================================================
        // Streams can be consumed only once.
        //
        // After a terminal operation (forEach, collect, count, etc.)
        // the Stream is closed.
        //
        // Trying to reuse it results in:
        //
        // IllegalStateException:
        // stream has already been operated upon or closed
        // ==========================================================

        Stream<Integer> streamData = list.stream();

        Stream<Integer> sortedStream2 = streamData.sorted();

        streamData
                .map(n -> n * n)
                .forEach(x -> System.out.println(x));
    }
}