public class PowerOfTwoXOR {

    public static boolean isPowerOfTwoUsingXor(int n) {
        if (n <= 0) return false;
        return (n ^ (n - 1)) == (2 * n - 1);
    }

    public static void main(String[] args) {
        int[] tests = {1, 2, 3, 4, 5, 8, 16, 18};
        for (int t : tests) {
            System.out.printf("%d is power of two? %b\n", t, isPowerOfTwoUsingXor(t));
        }
    }
}
