public class Pr05_06 {
    public static void main(String[] args) {

        int n = 5;
        int i = 1;
        int fact = 1;

        for(; i <= n; i++)
        {
            fact *= i;
        }
        System.out.println(fact);

        int fact1 = 1;
        i = 1;

        while(i <= n)
        {
            fact1 *= i;
            i++;
        }
        System.out.println(fact1);
    }
}
