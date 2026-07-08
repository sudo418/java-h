package oops.polymorphism;

class X {
    int a = 10;
    int b = 20;

    /*
     * Every class in Java implicitly extends the Object class.
     *
     * The Object class provides a method called toString().
     *
     * Default implementation of toString() returns:
     *
     *      FullyQualifiedClassName@HexadecimalHashCode
     *
     * Example:
     *      oops.polymorphism.X@5e2de80c
     *
     * This output is usually not meaningful to humans,
     * so we override toString() to return our own
     * readable representation of the object.
     */
    @Override
    public String toString() {
        return "Overriding{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
public class Overriding {
    static void main() {
        X x  = new X();

        /*
         * println(Object obj) internally calls:
         *      obj.toString();
         * So this line:
         */
        System.out.println(x);

        // is internally equivalent to:
        System.out.println(x.toString());

        /*
         * Since we have overridden toString(),
         * both statements print the same output:
         *
         * X{a=10, b=20}
         *
         * If we had NOT overridden toString(),
         * both statements would print something like:
         *
         * oops.polymorphism.X@5e2de80c
         *
         * because Java would use Object class's
         * default implementation of toString().
         */
    }
}
