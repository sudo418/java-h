public class Pr01_03_06 {

    static void table(int n)
    {
        for(int i = 1; i <= 10; i++)
        {
            System.out.println(n + " x " + i + " = " + n*i);
        }
    }

    static int sum(int n)
    {
        if (n == 1)
        {
            return 1;
        }
        else
        {
            return n + sum(n - 1);
        }
    }

    static int avg(int ...arr)
    {
        int sum = 0;
        for (int a: arr)
        {
            sum += a;
        }
        int total = sum/arr.length;
        return total;
    }

    public static void main(String[] args) {
        int n = 10;
        table(n);

        int a = 5;
        System.out.println(sum(5));

        System.out.println(avg(1,2,3));
    }
}
