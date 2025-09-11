package Bitonics;

public class BitonicPoint {
    public static int findBitonicPoint(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Handle boundary cases safely
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return arr[mid]; // Bitonic point found
                } else if (arr[mid] < arr[mid + 1]) {
                    low = mid + 1; // Go right
                } else {
                    high = mid - 1; // Go left
                }
            } else if (mid == 0) {
                return arr[0] > arr[1] ? arr[0] : arr[1];
            } else if (mid == arr.length - 1) {
                return arr[arr.length - 1] > arr[arr.length - 2] ? arr[arr.length - 1] : arr[arr.length - 2];
            }
        }

        return -1; // Should never reach here due to the problem's guarantee
    }

    // Test the function
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 7, 8, 3};
        System.out.println("Bitonic point is: " + findBitonicPoint(arr));
    }
}
