public class maximizingXor {

    public static int maximizingXor(int l, int r) {
        // Write your code here
        int xor = l ^ r;
        int significantBit = 0;

        // Find position of the most significant differing bit
        while (xor > 0) {
            significantBit++;
            xor >>= 1;
        }

        // Maximum XOR with that number of bits set
        return (1 << significantBit) - 1;

    }

}

