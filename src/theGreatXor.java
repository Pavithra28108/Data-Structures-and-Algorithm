public class theGreatXor {
    public static long theGreatXor(long x) {
    long result = 0;
    long power = 1;

    while (x > 0) {
        if ((x & 1) == 0) {
            result += power;
        }
        power <<= 1;
        x >>= 1;
    }

    return result;

}
    public static void main(String[] args) {
        // Hardcoded queries
        long[] queries = {2, 10};

        for (long x : queries) {
            long result = theGreatXor(x);
            System.out.println(result);
        }
    }


}
