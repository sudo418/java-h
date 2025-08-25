public class Pr02 {
    public static void main(String[] args) {

        int n = 5;
        int i = 0;
        int sum = 0;

        while(i < n)
        {
            sum = sum + (2*i);
            i++;
        };
        System.out.println(sum);

        System.out.println("Using for loop");

        int sum1 = 0;
        for(int a = 0; a < n; a++)
        {
            sum1 += (2*a);
        }
        System.out.println("The sum of first n natural number is "+ sum1);
    }
}
