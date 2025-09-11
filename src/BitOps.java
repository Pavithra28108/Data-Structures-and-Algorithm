public class BitOps {

    public static int getBit(int n, int i) {
        return (n >> i) & 1;
    }

    public static int setBit(int n, int i) {
        return n | (1 << i);
    }

    public static int clearBit(int n, int i) {
        return n & ~(1 << i);
    }

    public static void main(String[] args) {
        int n = 13; // binary 1101

        System.out.println("Original n = " + n);               // 13
        System.out.println("Get bit 2: " + getBit(n, 2));       // bit 2 is 1
        System.out.println("Set bit 1: " + setBit(n, 1));       // sets bit 1 → 15 (1111)
        System.out.println("Clear bit 3: " + clearBit(n, 3));   // clears bit 3 → 5 (0101)
    }
}
