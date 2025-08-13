public class LCMofArrayswithMod {

    static final long MOD = 1000000007;

    // Euclidean algorithm for GCD
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Function to find LCM of array under modulo
    static long lcmOfArray(int N, int A[]) {
        long lcm = A[0];

        for (int i = 1; i < N; i++) {
            long curr = A[i];
            long gcdVal = gcd(lcm, curr);

            // Reduce before multiplication to avoid overflow
            lcm = (lcm / gcdVal) % MOD;
            lcm = (lcm * (curr % MOD)) % MOD;
        }

        return lcm;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Example input array
        int[] A = {2, 7, 3, 9, 4};
        int N = A.length;

        // Call the LCM function
        long result = lcmOfArray(N, A);

        // Output the result
        System.out.println("LCM of the array is: " + result);
    }
}
