package ALGORITHM;

public class EasyQuickSort {

    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Get pivot
            quickSort(arr, low, pivotIndex - 1);        // Sort left part
            quickSort(arr, pivotIndex + 1, high);       // Sort right part
        }
    }

    // Partition the array and return pivot index
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choose last element as pivot
        int i = low - 1;        // Index of smaller element

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap pivot to the correct place
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // Print the array
    public static void printArray(int[] arr) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        int[] numbers = { 5, 3, 8, 4, 2, 7, 1, 10 };
        System.out.println("Before sorting:");
        printArray(numbers);

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("After sorting:");
        printArray(numbers);
    }
}
