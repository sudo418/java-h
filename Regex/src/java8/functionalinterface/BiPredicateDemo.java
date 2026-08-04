package java8.functionalinterface;

import java.util.function.BiPredicate;

public class BiPredicateDemo {
    static void main() {

        BiPredicate<Integer, Integer> bi = (n, m) -> n % 2 == 0 && m % 2 == 0;
        System.out.println(bi.test(4, 6));
        System.out.println(bi.test(4, 5));

        BiPredicate<String, Integer> bi2 = (str, n) -> str.length() == n;
        System.out.println(bi2.test("Chirayu", 7));

        BiPredicate<Integer, Integer> bi3 = (n, m) -> n > m;
        System.out.println(bi3.test(10, 8));
    }
}
