package collections.ch2_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class CollectionMethods {
    static void main() {

        Collection<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);

        // ==================== size() ====================
        System.out.println(c.size());

        // ==================== isEmpty() ====================
        System.out.println(c.isEmpty());
        // We can also check emptiness using:
        // c.size() == 0        explanation below (1)

        // ==================== contains(Object o) ====================
        System.out.println(c.contains(2));      // explanation below (5)


        Collection<Integer> c2 = new LinkedList<>();
        c2.add(1);
        c2.add(2);
        c2.add(3);

        // ==================== toArray() ====================
        Object[] obj = c2.toArray();
        for (Object o : obj) {
            System.out.println(o);
        }
        // toArray() returns an Object[].
        // So we can only access methods available in Object,
        // not Integer-specific or array-specific methods.

        System.out.println(obj); // [Ljava.lang.Object;@3feba861  explanation below (2)

        // ==================== toArray(T[] arr) ====================
        Integer[] arr = new Integer[0];
        Integer[] arr2 = c2.toArray(arr);
        for (Integer a : arr2) {
            System.out.println(a);
        }
        // We can also directly pass the array object:
        Integer[] arr3 = c2.toArray(new Integer[0]); // explanation below (3)

        // ==================== add(E e) ====================   explanation below (4)
        Collection<Integer> c3 = new HashSet<>();
        c3.add(1);
        c3.add(2);
        c3.add(3);

        boolean isAdded = c3.add(3);
        System.out.println(isAdded);
        /*  3 is already present in the HashSet.
            HashSet does not allow duplicate elements, so this attempt
            does not change the collection.
            Therefore add(3) returns false. */
    }
}
/*
 * ============================================================
 * (1) isEmpty() vs size() == 0
 * ============================================================
 *
 * Both of these return true or false:
 *
 * c.isEmpty()
 * c.size() == 0
 *
 * isEmpty() is preferred because its purpose is directly
 * to check whether the collection is empty.
 *
 * Its implementation can also be optimized depending on
 * the data structure.
 *
 * For example, a collection can simply check whether its
 * internal size is 0 instead of doing any traversal.
 */


/*
 * ============================================================
 * (2) Why does System.out.println(obj) print
 *     [Ljava.lang.Object;@3feba861 ?
 * ============================================================
 *
 * obj is an array.
 *
 * Arrays do not override toString() to print their elements.
 * So when we directly print the array:
 *
 * System.out.println(obj);
 *
 * Java uses the array object's default toString() representation.
 *
 * [Ljava.lang.Object;@3feba861
 *
 * Here:
 *
 * [                  -> array
 * L                  -> reference type
 * java.lang.Object   -> type of elements in the array
 * @3feba861          -> hash-related hexadecimal value
 *
 * To print the actual elements, we can use:
 *
 * Arrays.toString(obj)
 *
 * which gives:
 *
 * [1, 2, 3]
 */


/*
 * ============================================================
 * (3) Why do we use new Integer[0]?
 * ============================================================
 *
 * We can write:
 *
 * Integer[] arr3 = c2.toArray(new Integer[0]);
 *
 * Here, new Integer[0] is mainly used to tell toArray()
 * that we want an Integer[] as the result.
 *
 * The 0 does NOT mean that the final result will be empty.
 *
 * toArray() returns an array containing the elements of
 * the collection.
 *
 * We can also write:
 *
 * new Integer[5]
 *
 * but creating an array of size 5 is unnecessary here because
 * we only need to specify the array type.
 */


/*
 * ============================================================
 * (4) add(E e)
 * ============================================================
 *
 * add(E e) adds an element to the collection.
 *
 * It returns a boolean:
 *
 * true  -> element was successfully added
 * false -> element was not added
 *
 * Whether duplicate elements are allowed depends on the
 * collection implementation.
 *
 * ArrayList -> allows duplicate elements
 * HashSet   -> does not allow duplicate elements
 *
 * Example:
 *
 * c3.add(3);
 *
 * Since 3 is already present in the HashSet, it is not added
 * again and add(3) returns false.
 */

/*
 * ============================================================
 * (5) Why does contains() take Object o?
 * ============================================================
 *
 * contains(Object o) checks whether the collection contains
 * an element equal to the given object.
 *
 * Object is used because every Java object is ultimately an
 * Object, and Object provides the equals() method.
 *
 * For example:
 *
 * c.contains(2);
 *
 * Here 2 is autoboxed to an Integer object.
 * Integer is a subclass of Object, so it can be passed to
 * the Object parameter.
 *
 * We don't need to explicitly create an Object:
 *
 * Object o = Integer.valueOf(2);
 *
 * This works because Integer IS-A Object.
 *
 * contains() can then compare the given object with the
 * elements using equals().
 *
 * We could think of it as:
 *
 * element.equals(o)
 *
 * So contains(Object o) means:
 *
 * "Give me any object, and I will check whether an equal
 * object is present in the collection."
 */