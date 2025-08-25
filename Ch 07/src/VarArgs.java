public class VarArgs {

    /* If we wanna do this with method overloading then
    we have to many methods by VarArgs we can do it with
    only 1 method */

    static int sum(int ...arr)
    {
        int result = 0;
        for(int a: arr)
        {
            result += a;
        }
        return result;
    }

    // If you want to make 1 argument compulsory :-
    static int hello(int x, int ...arr)
    {
        int result = x;
        for (int a: arr)
        {
            result += a;
        }
        return result;
    }
    public static void main(String[] args) {

        System.out.println(sum(1,2));
        System.out.println(sum(1,2,3));
        System.out.println(sum(1,2,3,4));

        System.out.println(hello(1,3));
    }
}
