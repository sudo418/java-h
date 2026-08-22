package collections.ch03_List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NestedList {
    static void main() {

        // ==================== Creating Nested ArrayList ====================
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);

        al.add(row1);
        al.add(row2);

        System.out.println(al);
        System.out.println(row1);
        System.out.println(row2);

        // ==================== Accessing Nested Elements ====================
        System.out.println(al.get(1));          // Gets the row at index 1  (for row)
        System.out.println(al.get(1).get(1));   // Gets the element at row 1, index 1 (for coloumn)

        // ==================== Modifying Nested Elements ====================
        al.get(0).set(1, 20);
        System.out.println(al);

        // System.out.println(al.get(0).set(1, 20));  --> set() returns the element that was replaced.

        // ==================== Adding Elements to an Inner List ====================
        al.get(1).add(70);
        System.out.println(al);

        // ==================== Removing Elements from an Inner List ====================
        al.get(1).remove(2);
        System.out.println(al);

        // ==================== Nested Iteration Using Enhanced For Loop ====================
        for (ArrayList<Integer> row : al) {
            for (Integer value : row) {
                System.out.println(value);
            }
        }

        // ==================== Nested Iteration Using Iterator ====================
        System.out.println("Using iterator");

        Iterator<ArrayList<Integer>> outer = al.iterator();
        while (outer.hasNext()) {
            ArrayList<Integer> row = outer.next();
            Iterator<Integer> inner = row.iterator();

            while (inner.hasNext()) {
                System.out.println(inner.next());
            }
        }


        // ==================== Nested List Using List Interface ====================
        List<List<Integer>> list = new ArrayList<>();

        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);

        list.add(l);
        System.out.println(list);


        // ==================== Different Nested List Combinations ====================
        LinkedList<LinkedList<Integer>> linked = new LinkedList<>();
        LinkedList<ArrayList<Integer>> linkedArray = new LinkedList<>();

        // ArrayList<LinkedList<Integer>> arrayLinked = new LinkedList<>();  ❌
        // The outer type is ArrayList, but the object created is LinkedList.
        // LinkedList is not a subclass of ArrayList, so this is invalid
        ArrayList<LinkedList<Integer>> arrayLinked = new ArrayList<>();

        List<ArrayList<Integer>> listArray = new ArrayList<>();
        List<LinkedList<Integer>> listLinked = new LinkedList<>();
    }
}
