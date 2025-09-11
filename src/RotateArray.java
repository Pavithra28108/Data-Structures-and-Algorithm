import java.util.Arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // In case k > n

        // Step 1: Reverse the whole array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the rest
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // Swap elements
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;

        rotate(nums, k);
        System.out.println("Rotated array: " + Arrays.toString(nums));
    }
}
