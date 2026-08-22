package collections.ch03_List;

import java.util.ArrayList;

public class ArrayListDemo {

    // ==================== Accessing protected removeRange() ====================
    static class MyArrayList<E> extends ArrayList<E> {
        public void removeRangeElements(int frontIndex, int toIndex) {
            removeRange(frontIndex, toIndex);
        }
    }

    static void main() {
        // ==================== clone() ====================
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(20);
        al.add(30);

        ArrayList<Integer> copy = (ArrayList<Integer>) al.clone();

        System.out.println("Original list: " + al);
        System.out.println("Cloned list: " + copy);

        copy.add(40);

        System.out.println("Original list after modifying clone: " + al);
        System.out.println("Cloned list after modification: " + copy);


        // ==================== ensureCapacity() ====================
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(20);

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("\nList after ensureCapacity(): " + list);
        System.out.println(list.size());
        // size = 3
        // capacity = 20


        // ==================== trimToSize() ====================
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(50);
        list2.add(40);
        list2.add(30);

        list2.trimToSize();
        System.out.println("\n List after trimToSize(): " + list2);


        // ==================== removeRange() ====================
        MyArrayList<Integer> list3 = new MyArrayList<>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        list3.add(6);

        System.out.println("\n Original list: " +list3);

        list3.removeRangeElements(1, 4);    // 4 is excluded
        System.out.println("List after removing range: " +list3);
    }
}