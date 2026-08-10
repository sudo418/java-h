package collections.ch01_Iterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableDemo {
    static void main() {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        Iterator<Integer> it = list.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
