public class BreakContinue {
    public static void main(String[] args) {

        int i = 5;

        for(; i > 0; i--)
        {
            System.out.println(i);
        }

        System.out.println("loop for printing first n natural numbers in reverse");
        int n = 5;

        for (int a = n; a != 0; a--)
        {
            System.out.println(a);
        }

        for(int a = 0; a < 5; a++)
        {
            System.out.println(a);
            if(a == 3)
            {
                break;
            }
        }

        for(int b = 0; b < 5; b++)
        {
            if(b == 3)
            {
                continue;
            }
            System.out.println(b);
        }

        /* This logic is wrong cuz it will print 3. The continue keyword skip the
        statements below it. If there is no line below continue then there is no use
        of it */
        for(int b = 0; b < 5; b++)
        {
            System.out.println(b);
            if(b == 3)
            {
                continue;
            }
        }


    }
}
