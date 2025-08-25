public class Array {

    static void change(int[] x)
    {
            x[0] = 99;
    }

    static void hello()
    {
        System.out.println("Hello World!");
    }

    static void hello(int a)
    {
        System.out.println(a);
    }

    static void hello(int a, int b)
    {
        System.out.println(a + "," + b);
    }

    /* static int hello(int a, int b)      --> This will give error
    {
        int z = a + b;
        return z;
    }
    NOTE: Java decides which overloaded method to call by looking at the method name + parameter list.
    It does NOT consider the return type when choosing the method.
    So: changing only the return type will cause a compile-time error!
    */

    static int hello(int a, int b, int c)
    {
        return 4;
    }
    /* is valid overloading because:
    The method name is the same (hello)
    The parameter list is different (it has three ints)
    Java only cares about the name + parameter types/number for
    overloading — the return type can be anything (void, int, double,
    etc.), but it’s ignored when deciding which method to call. */


    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        change(a);
        System.out.println(a[0]);

        hello();
        hello(3);
        hello(3,5);
        
        // int z = hello(1,2,3);  --> error explained above
        // System.out.println(z);
    }
}
