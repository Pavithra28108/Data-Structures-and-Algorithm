public class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int maxDiff = -1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > min) {
                maxDiff = Math.max(maxDiff, nums[j] - min);
            } else {
                min = nums[j];  // update min if current is smaller
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        MaximumDifferenceBetweenIncreasingElements sol = new MaximumDifferenceBetweenIncreasingElements();

        int[] nums1 = {7, 1, 5, 4};
        System.out.println("Max diff: " + sol.maximumDifference(nums1));  // Output: 4
    }
    }
