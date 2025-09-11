public class OddOccurrence {
    public static int findOdd(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;  // XOR each number
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3, 1, 5};
        System.out.println("Odd occurring number: " + findOdd(arr));
    }
}
