package java8.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {
    static void main() {
        // ===============Source List================
        List<Integer> li = Arrays.asList(2,5,6,44,7,8,44,55,77,43,9,56,5,78,76);

        // ===============filter(): Print Even Numbers================
        Stream<Integer> evenStream = li.stream().filter(x -> x % 2 == 0);
        evenStream.forEach(x -> System.out.println(x));

        // ===============filter() + collect(): Store Odd Numbers in a List================
        List<Integer> oddStream = li.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
        System.out.println(oddStream);

        // ===============filter() + map(): Divide Even Numbers by 2================
        List <Integer> divide2evenStream = li.stream().filter(x -> x % 2 == 0).map(x -> x / 2).collect(Collectors.toList());
        // printing both the list side by side
        List<Integer> evenList = li.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(evenList);
        System.out.println(divide2evenStream);


        // ===============Source List================
        List<Integer> li2 = Arrays.asList(3,7,5,9,1,6,7,8,8,1);

        // after java 16 to don't need to write collect(Collectors.toList())
        List<Integer> distinctList = li2.stream().distinct().toList();
        System.out.println(distinctList);

        // ===============sorted(): Sort Elements in Descending Order using Comparator===============
        List<Integer> sortedLi = li2.stream().distinct().sorted((a, b) -> (b - a)).toList();
        System.out.println(sortedLi);


        // ===============Stream Pipeline Example================
        // iterate() -> limit() -> skip() -> peek() -> filter() -> map() -> distinct() -> toList()
        List<Integer> l3 = Stream.iterate(0, x -> ++x)      // x++ will give error
                .limit(51)
                .skip(1)        // skips first place which is 0
                .peek(x -> System.out.println(x))
                .filter(x -> x % 2 == 0)
                .map(x -> x / 10)
                .distinct()
                .toList();
        System.out.println(l3);

        // ===============max(): Find the Maximum Element================
        Integer integer = Stream.iterate(0, x -> x + 1)
                .limit(51)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 10)
                .distinct()
                .max((a, b) -> b - a)
                .get();
        System.out.println(integer);

        // ===============count(): Count the Number of Elements================
        Long long1 = Stream.iterate(0, x -> ++x)
                .limit(101)
                .map(x -> x / 20)
                .distinct()
                .count();
        System.out.println(long1);
    }
}