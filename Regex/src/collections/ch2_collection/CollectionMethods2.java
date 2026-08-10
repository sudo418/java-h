package collections.ch2_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class CollectionMethods2 {
    static void main() {
        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(5);
        c.add(6);

        // ==================== remove() ====================
        // List has 2 overloaded methods:
        // remove(int index)
        // remove(Object o)

        // → remove(int index)
        c.remove(1);   // removes index 1, so value 2 is removed

        // → remove(Object o)
        c.remove((Integer) 6);
        c.remove(Integer.valueOf(3)); // explanation below

        // ==================== remove() for HashSet ====================
        Collection<Integer> c2 = new HashSet();
        c2.add(1);
        c2.add(2);
        c2.add(3);
        c2.add(3);      // duplicate is not added

        System.out.println(c2.remove(3)); // removes the first 3 as second 3 is not added
        for (Integer i : c2) {
            System.out.println(i);
        }

        // ==================== addAll(Collection<? extends E> c) ====================
        c2.addAll(List.of(4,5,6,7));
        System.out.println(c2);

        // ==================== containsAll(Collection<?> c) ====================
        System.out.println(c2.containsAll(List.of(1,2,3,4)));

        // ==================== removeAll(Collection<?> c) ====================
        c2.removeAll(List.of(1,2));
        System.out.println(c2);

        // ==================== retainAll(Collection<?> c) ====================
        c2.retainAll(List.of(5,6));
        System.out.println(c2);

        // ==================== clear() ====================
        c2.clear();
        System.out.println(c2);
    }
}
/*
 * ============================================================
 * How does remove(Integer.valueOf(3)) remove the 3?
 * ============================================================
 *
 * Suppose the collection already contains an Integer object
 * representing 3:
 *
 * Collection
 *    |
 *    ↓
 * ┌──────────────────┐
 * │ Integer object   │
 * │ value = 3        │
 * └──────────────────┘
 *
 *
 * Now we write:
 *
 * c.remove(Integer.valueOf(3));
 *
 * Integer.valueOf(3) returns another Integer object containing 3:
 *
 * Integer.valueOf(3)
 *        ↓
 * ┌──────────────────┐
 * │ Integer object   │
 * │ value = 3        │
 * └──────────────────┘
 *
 * So there can be two different Integer objects:
 *
 *   Object inside collection       Object given to remove()
 *             │                              │
 *             ↓                              ↓
 *      ┌──────────────┐              ┌──────────────┐
 *      │ Integer      │              │ Integer      │
 *      │ value = 3    │              │ value = 3    │
 *      └──────────────┘              └──────────────┘
 *
 * They do not have to be the same object.
 *
 * remove(Object o) uses equals() to compare the object given
 * to it with the elements already present in the collection.
 *
 * Conceptually:
 *
 * existingElement.equals(o)
 *             ↓
 *           true
 *
 * Since both Integer objects represent the value 3, equals()
 * returns true.
 *
 * Therefore, remove() removes the EXISTING Integer object
 * from the collection.
 *
 * The Integer object given through Integer.valueOf(3) is only
 * used for comparison. It is not added to the collection, and
 * it is not the object being removed.
 *
 *
 * Flow:
 *
 * Integer.valueOf(3)
 *        ↓
 * Integer object containing 3
 *        ↓
 * passed to remove(Object o)
 *        ↓
 * compared using equals()
 *        ↓
 * equal element found
 *        ↓
 * existing element is removed
 */