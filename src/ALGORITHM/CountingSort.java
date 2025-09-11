package ALGORITHM;

public class CountingSort {


    // Function to perform counting sort
    public void countingSort(int[] arr) {
        int n = arr.length;

        // Step 1: Find the maximum value in the array
        int max = arr[0];
        for (int num : arr) {
            if (num > max) max = num;
        }

        // Step 2: Create a count array
        int[] count = new int[max + 1];

        // Step 3: Store the frequency of each element
        for (int num : arr) {
            count[num]++;
        }

        // Step 4: Modify count[] so that each element
        // at each index stores the sum of previous counts
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Step 5: Build the output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            output[count[num] - 1] = num;
            count[num]--;
        }

        // Step 6: Copy the output array back to original array
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // Utility to print array
    public void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        CountingSort sorter = new CountingSort();

        System.out.println("Original Array:");
        sorter.printArray(arr);

        sorter.countingSort(arr);

        System.out.println("Sorted Array:");
        sorter.printArray(arr);
    }
}
