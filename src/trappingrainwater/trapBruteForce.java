package trappingrainwater;

public class trapBruteForce {
    // Brute force approach: O(n^2)
    public static int trapBruteForce(int[] height) {
        int n = height.length;
        int water = 0;

        // For each index, find max left and max right
        for (int i = 0; i < n; i++) {
            int leftMax = 0, rightMax = 0;

            // Find the tallest bar to the left of i
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the tallest bar to the right of i
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Water trapped at current index
            water += Math.min(leftMax, rightMax) - height[i];
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trapBruteForce(height);

        System.out.println("Total trapped rainwater: " + result);
    }

}
