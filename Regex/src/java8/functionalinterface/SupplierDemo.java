package java8.functionalinterface;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {
    static void main() {

        Supplier<Integer> s = () -> (int) (Math.random() * 10);
        System.out.println(s.get());

        Supplier<Integer> random = () -> new Random().nextInt();
        System.out.println(random.get());

        Supplier<String> s2 = () -> "Hello world!";
        System.out.println(s2.get());

        // writing above code using anonymous class
        Supplier<String> s3 = new Supplier<String>() {
            @Override
            public String get() {
                return "Same with anonymous class";
            }
        };
        System.out.println(s3.get());
    }
}
