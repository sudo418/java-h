public class Pr09 {
    public static void main(String[] args) {

        int n = 8;
        int sum = 0;

        for(int i = 1; i < 11; i++)
        {
            System.out.println(n + "x" + i + "=" + n*i);
        }

        for(int i = 1; i < 11; i++)
        {
            sum = sum + n*i;
        }
        System.out.println(sum);
    }
}
