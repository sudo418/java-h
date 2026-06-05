public class Pr01_02 {
    public static void main(String[] args) {

        float a = 7 / 4 * 9 / 2;
        System.out.println(a);

        /* it will give 4 cuz 7/4 is int and it will give 1 and after
        multiplying it with 9 it will give 9 and after dividing it
        with 2 it will give 4
        */
        float b = 7 / 4f * 9 / 2f;
        System.out.println(b);

        char grade = 'a';
        grade = (char) (grade + 8);
        /* had to typecast in char cuz int + char = int so
        grade + 8 = int and we are storing it in char variable
        which is wrong so we convert it into char
        */

        System.out.println(grade);

        // decrypt :-

        grade = (char) (grade - 8);
        System.out.println(grade);
    }
}
