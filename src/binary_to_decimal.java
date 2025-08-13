public class binary_to_decimal {

    public static int binary_to_decimal(String b) {
        int decimal = 0;
        int power = 0;

        // Loop from right to left
        for (int i = b.length() - 1; i >= 0; i--) {
            char bit = b.charAt(i);

            if (bit == '1') {
                decimal += Math.pow(2, power);
            }

            power++;
        }

        return decimal;
    }

    // Main method to test
    public static void main(String[] args) {
        String binary = "100001";  // Example input
        int result = binary_to_decimal(binary);
        System.out.println("Decimal value: " + result); // Output: 33
    }

}

