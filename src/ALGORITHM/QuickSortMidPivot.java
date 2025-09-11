package ALGORITHM;

public class QuickSortMidPivot {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;

        // Choose middle element as pivot
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        int i = low;
        int j = high;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
                j--;
            }
        }

        // Recursively sort left and right parts
        if (low < j) quickSort(arr, low, j);
        if (i < high) quickSort(arr, i, high);
    }

    public static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 4, 6, 2, 8, 5};
        System.out.println("Before sorting:");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("After sorting:");
        printArray(arr);
    }
}
