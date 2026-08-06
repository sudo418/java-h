package java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Creation {
    static void main() {
        // ======== 1st Way: Create a Stream from a List ==========
        List<String> list = Arrays.asList("apple", "banana", "mango");
        System.out.println(list);

        // Use the stream directly if it is needed only once.
        list.stream().forEach(s -> System.out.println(s));

        // Store the Stream object returned by list.stream().
        Stream<String> myStream = list.stream();

        // myStream.forEach(s -> System.out.println(s));
        // Equivalent code using a Method Reference.
        myStream.forEach(System.out::println);
        // forEach() accepts a Consumer functional interface.


        // ===============2nd Way: Create a Stream from an Array================
        String[] array = {"apple", "cherry", "kiwi"};
        Stream<String> ms2 = Arrays.stream(array);


        // ===============3rd Way: Create a Stream using Stream.of()================
        Stream<String> stream = Stream.of("apple", "banana", "mango");
        stream.forEach(x -> System.out.println(x));


        // ===============4th Way: Create a Stream using Stream.iterate()================
        Stream<Integer> limit = Stream.iterate(0, x -> x + 1).limit(5);
        limit.forEach(x -> System.out.println(x));


        // ===========5th Way: Create a Stream using Stream.generate()============
        Stream<Integer> limit1 = Stream.generate(() -> (int) (Math.random() * 10)).limit(5);
        limit1.forEach(x -> System.out.println(x));


        // ========Example: Generate the Multiplication Table of 3=======
        Stream<Integer> table3 = Stream.iterate(3, x -> x + 3).limit(10);
        table3.forEach(x -> System.out.println(x));

        // ========Example: Generate Powers of 2=========
        Stream<Integer> square = Stream.iterate(1, x -> x * 2).limit(10);
        square.forEach(x -> System.out.println(x));
    }
}
