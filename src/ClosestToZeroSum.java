import java.util.Arrays;

public class ClosestToZeroSum {

    public static int closestToZero(int[] arr) {
        Arrays.sort(arr); // Sort array first
        int left = 0;
        int right = arr.length - 1;

        int closestSum = Integer.MAX_VALUE;

        while (left < right) {
            int sum = arr[left] + arr[right];

            // Update closestSum if needed
            if (Math.abs(sum) < Math.abs(closestSum)) {
                closestSum = sum;
            } else if (Math.abs(sum) == Math.abs(closestSum)) {
                closestSum = Math.max(closestSum, sum);
            }

            // Move pointers
            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        return closestSum;
    }

    public static void main(String[] args) {
        int[] arr = {-8, -66, -60};
        System.out.println("Closest sum to zero: " + closestToZero(arr)); // Output: -68
    }
}
