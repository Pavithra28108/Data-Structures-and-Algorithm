public class GCDEuclidean {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("GCD(0, 0) is undefined");
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int a = 18;
        int b = 48;

        int result = gcd(a, b);
        System.out.println("GCD of " + a + " and " + b + " is: " + result);
    }
}


