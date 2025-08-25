public class Pr01 {
    public static void main(String[] args) {
        String name = "CHIRAYU";
        name = name.toLowerCase();
        System.out.println(name);

        String name1 = "  avi   ";
        name1 = name1.replace(" ", "_");
        System.out.println(name1);

        String name2 = "  avi    ";
        System.out.println(name2.indexOf("  "));
        System.out.println(name2.indexOf("   "));
        System.out.println(name2.indexOf("     "));

        String letter = "Dear Harry,\n\tThis java course is nice.\n\tThanks.";
        System.out.println(letter);

    }
}
