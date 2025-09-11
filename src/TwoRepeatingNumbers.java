import java.util.ArrayList;
import java.util.List;

public class TwoRepeatingNumbers {

    public static List<Integer> findRepeating(int[] arr, int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]);

            // Check if the value at that index is already negative
            if (arr[index - 1] < 0) {
                // Second appearance → duplicate found
                result.add(index);

                // If we found both, we can stop
                if (result.size() == 2) break;
            } else {
                // First appearance → mark as visited
                arr[index - 1] = -arr[index - 1];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 1, 3, 4, 3};

        List<Integer> repeating = findRepeating(arr, n);
        System.out.println("Repeating numbers: " + repeating); // Output: [1, 3]
    }
}
