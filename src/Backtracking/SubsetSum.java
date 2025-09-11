package Backtracking;

public class SubsetSum {

    static boolean isSubsetSum(int[] arr, int sum) {
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true; // sum = 0 is always possible (empty subset)

        for (int num : arr) {
            // Update backwards to avoid reusing the same element
            for (int j = sum; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;

        System.out.println("Subset with sum " + sum + " exists: " + isSubsetSum(arr, sum));
    }
}
