package collections.ch03_List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListMethods {
    static void main() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.get(1));

        list.set(1, 5);
        System.out.println(list);

        list.addAll(1, List.of(7,8,9,1));
        System.out.println(list);

        System.out.println(list.indexOf(8));

        System.out.println(list.lastIndexOf(5));

        list.remove(4);

        // ==================== Forward Iteration ====================
        System.out.println("Iterating the list: ");
        ListIterator<Integer> li = list.listIterator();
        while (li.hasNext()) {
            System.out.println(li.next());
        }

        // ==================== Reverse Iteration ====================
        System.out.println("Printing the list in reverse order: ");
        // this will not print last index 5 is exclusive
        // ListIterator<Integer> li2 = list.listIterator(5);
        // to print we have to use :-
        ListIterator<Integer> li2 = list.listIterator(6);
        while (li2.hasPrevious()) {
            System.out.println(li2.previous());
        }

        // ==================== Previous Index ====================
        System.out.println("printing the previous index: ");
        ListIterator<Integer> li3 = list.listIterator(6);
        while(li3.hasPrevious()) {
            System.out.println(li3.previousIndex());
            li3.previous();
        }

        System.out.println("adding element in unmodifiable list: ");
        List<Integer> l1 = List.of(1,2,3,4,5,6,7,8);
        try {
            l1.add(9);      // List.of() creates an unmodifiable list, so elements cannot be
                            // added, removed, or replaced after the list is created
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }


        List<Integer> l2 = List.copyOf(l1);  // List.copyOf() creates an unmodifiable copy of the given collection
        System.out.println(l2);
        try {
            l2.add(9);      // Throws UnsupportedOperationException
        }
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
/*
 * ================ Why is the position in ListIterator exclusive? ===================
 *
 * ListIterator works with a cursor (position), not directly on an element.
 *
 * For example, consider the list:
 *
 *     Index:       0     1     2
 *                  ↓     ↓     ↓
 *     Element:    [1]   [2]   [3]
 *
 * There are actually four possible cursor positions:
 *
 *                  0     1     2     3
 *                  ↓     ↓     ↓     ↓
 *                 [1]   [2]   [3]
 *
 *     Position 0 → before element 1
 *     Position 1 → between 1 and 2
 *     Position 2 → between 2 and 3
 *     Position 3 → after element 3
 *
 * Therefore:
 *
 *     ListIterator<Integer> li = list.listIterator(3);
 *
 *     [1] [2] [3] |
 *                ↑
 *              cursor
 *
 * The cursor is at position 3, after element 3.
 *
 * Conceptually, previous() works like:
 *
 *     hasPrevious() → cursor > 0
 *
 *     previous() {
 *         return list[--cursor];
 *     }
 *
 * --cursor is used because previous() must first move the cursor
 * one position backward and then return the element at that position.
 *
 *     cursor = 3
 *     --cursor → 2
 *     list[2]  → 3
 *
 * Therefore:
 *
 *     listIterator(3).previous() → 3
 *
 * If we use:
 *
 *     list[cursor--]
 *
 * cursor-- uses the OLD value first and decreases the cursor afterward.
 *
 *     cursor = 3
 *     list[cursor--] → list[3]
 *
 * But the valid indexes are only 0, 1, and 2.
 * Therefore, list[3] does not exist and it will throw
 * ArrayIndexOutOfBoundsException.
 *
 * This is why previous() uses --cursor instead of cursor--.
 *
 * Similarly, next() conceptually works like:
 *
 *     hasNext() → cursor < size
 *     next()    → list[cursor++]
 *
 * next() uses the current position first and then moves forward,
 * while previous() moves backward first and then uses that position.
 */