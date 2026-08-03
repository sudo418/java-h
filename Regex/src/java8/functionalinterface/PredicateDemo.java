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

        // optimize the above code
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
    }
}
