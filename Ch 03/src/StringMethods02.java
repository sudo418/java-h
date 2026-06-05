public class StringMethods02 {
    public static void main(String[] args) {
        String name = "Chirayu";

        System.out.println(name.startsWith("Ch"));
        System.out.println(name.startsWith(""));
        //true (empty string is always a prefix)

        System.out.println(name.startsWith("ra", 3));

        System.out.println(name.endsWith("u"));
        // startsWith and endsWith takes only String as parameters, not char

        System.out.println(name.charAt(3));

        System.out.println(name.indexOf("ir"));
        // Returns the index of the first occurrence of the specified substring

        String example = "Harry";
        System.out.println(example.indexOf("r"));

        System.out.println(example.indexOf("ry"));
        /*
        Returns the index where the substring "ry" starts.
        Although 'r' is at index 2, "ry" is not found at
        index 2 instead, "ry" starts at index 3, so it returns 3 */

        String modifiedName = "Harryrry";
        System.out.println(modifiedName.indexOf("rry"));
        System.out.println(modifiedName.indexOf("rry", 4));

        System.out.println(modifiedName.indexOf("z"));
        // If it doesn't get a match then it returns -1

        System.out.println(modifiedName.lastIndexOf("rry"));
        // It starts searching from the end to the starting(move backwards)

        System.out.println(modifiedName.lastIndexOf("rry", 4));

        String ex2 = "Harryrryrry";
        System.out.println(ex2.lastIndexOf("rry", 7));

        System.out.println(example.equals("Harry"));
        System.out.println(example.equals("harry"));

        System.out.println(example.equalsIgnoreCase("harry"));
        System.out.println(example.equalsIgnoreCase("haRRy"));

    }
}
