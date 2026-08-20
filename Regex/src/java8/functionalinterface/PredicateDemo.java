package java8.functionalinterface;

import java.util.function.Predicate;

public class PredicateDemo {
    static void main() {

        Predicate<Integer> p = (num) -> {
          if (num % 2 == 0) {
              return true;
          }
          else return false;
        };
        System.out.println(p.test(10));

        // optimizing the above code
        Predicate<Integer> p2 = num -> num % 2 == 0;
        System.out.println(p2.test(5));

        Predicate<String> s = (name) -> {
          if (name.isEmpty()) return true;
          else return false;
        };
        System.out.println(s.test("hello"));
        System.out.println(s.test(""));

        // optimize version of the above code
        Predicate<String> s2 = name -> name.isEmpty();
        System.out.println(s2.test(""));
        System.out.println(s2.test("hello"));

        // writing with anonymous class
        Predicate<String> s3 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                if (s.isEmpty()) {
                    return true;
                }
                else return false;
            }
        };

        Predicate<String> startWithH = x -> x.toLowerCase().charAt(0) == 'h';
        Predicate<String> endWithO = x -> x.toLowerCase().charAt(x.length() - 1) == 'l';
        Predicate<String> and = startWithH.and(endWithO);
        System.out.println(and.test("hello"));

        Predicate<String> or = startWithH.or(endWithO);
        System.out.println(or.test("hellow"));

        System.out.println(startWithH.negate().test("hello"));

        Predicate<String> predicate = Predicate.isEqual("Hello");
        System.out.println(predicate.test("Hello"));
    }
}
