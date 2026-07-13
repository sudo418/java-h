package exceptionhandling;

public class NestedTryCatchExample {
    public static void main(String[] args) {
        try {
            System.out.println("hello");

            try {
                int[] nums = {1,2,3};
                System.out.println(nums[5]);
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);

                int result = 10 / 0;
            }

        }
        catch (ArithmeticException e) {
            System.out.println(e);
        }
    }
}
