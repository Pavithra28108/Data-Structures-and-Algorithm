package ALGORITHM;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert the key in its correct position
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {8, 4, 2, 9, 5};

        System.out.println("Before sorting:");
        printArray(numbers);

        insertionSort(numbers);

        System.out.println("After sorting:");
        printArray(numbers);
    }
}
