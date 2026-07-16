public class PracRegex {
    public static void main(String[] args) {
        String s1 = new String("Hello");
        String s2 = new String("Hello");
        String s3 = new String("Hello");
        String s4 = "Hello";
        String s5 = "Hello";

        System.out.println(".equals"); // Content comparison
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s5));

        System.out.println("==");   //Reference comparison
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s1 == s5);
        System.out.println(s2 == s3);
        System.out.println(s2 == s4);
        System.out.println(s2 == s5);
        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s4 == s5);  //Same object reused from SCP

        /*  SCP (String Constant Pool) - a special reserved area inside the heap
            where Java stores String literals. If an identical literal already
            exists in the pool, Java reuses the same object instead of creating
            a new one (saves memory).
            Strings created with 'new' -> each is a separate, new object in Heap.
            Strings created using a literal -> stored/reused in String Constant Pool (SCP). */
    }
}
