package java8.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
    static void main() {

        Function<String, Integer> f = str -> str.length();
        System.out.println(f.apply("name"));

        Function<Integer, Integer> f2 = n -> n * n;
        System.out.println(f2.apply(5));

        Function<String, String> f3 = s -> s.toUpperCase();
        System.out.println(f3.apply("helloworld"));

        // above code with anonymous class
        Function<String, String> f4 = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };
        System.out.println(f4.apply("hello intellij"));


        Function<String, String> sub = str -> str.substring(0, 3);
        // just going deep :-
        Function<List<Student>, List<Student>> studentsWithPrefixHel = li -> {
            List<Student> result = new ArrayList<>();
            for (Student s : li) {
                if (sub.apply(s.getName()).equalsIgnoreCase("hel")) {
                    result.add(s);
                }
            }
            return result;
        };

        Student s1 = new Student(1, "helloworld");
        Student s2 = new Student(2, "helloworld323");
        Student s3 = new Student(3, "java8");
        List<Student> students = Arrays.asList(s1, s2, s3);
        List<Student> filteredStudents = studentsWithPrefixHel.apply(students);
        System.out.println(filteredStudents);
        // till here

        Function<Integer, Integer> func = n -> 2 * n;
        Function<Integer, Integer> func2 = n -> n * n * n;

        System.out.println(func.andThen(func2).apply(3));   // 216
        System.out.println(func2.andThen(func).apply(3));   // 54

        System.out.println(func.compose(func2).apply(3));   // 54

        Function<String, String> identityFunction = Function.identity();
        System.out.println(identityFunction.apply("this is identity function"));



        // ===========BiFunction===========
        BiFunction<Integer, Integer, Integer> bf = (n, m) -> n + m;
        System.out.println(bf.apply(5, 8));

        BiFunction<String, String, Integer> bf2 = (x, y) -> x.length() + y.length();
        System.out.println(bf2.apply("hi", "hello"));
    }

    private static class Student {
        int id;
        String name;

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}