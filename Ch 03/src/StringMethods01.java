public class StringMethods01 {
    public static void main(String[] args) {
        String name = "Chirayu";

        int value = name.length();
        System.out.println(value);

        String lowerString = name.toLowerCase();
        System.out.println(lowerString);

        String upperString = name.toUpperCase();
        System.out.println(upperString);

        /* Strings are immutable, so methods don't change the original string
        instead, they create and return a new one. */

        name = name.toUpperCase();
        System.out.println(name);

        /*  The reference 'name' now points to a new String object ("CHIRAYU").
        The original string wasn't modified — a new one was created. */

        String nonTrimmedString = "       Chirayu   ";

        // method 1
        String trimmedString = nonTrimmedString.trim();
        System.out.println(trimmedString);

        // method 2
        System.out.println(nonTrimmedString.trim());

        System.out.println(name.substring(2));
        System.out.println(name.substring(2, 6));
        /* beginning index is included and end index is excluded
        2 is included and 6 is excluded */

        System.out.println(name.substring(2, 7));
        // To include the last character, set the end index to (last index + 1)

        String exampleName = "Harry";

        // It changes both the 'r'
        System.out.println(exampleName.replace('r', 'p'));

        System.out.println(exampleName.replace("rry", "ier"));
        System.out.println(exampleName.replace("r", "ier"));

    }
}
