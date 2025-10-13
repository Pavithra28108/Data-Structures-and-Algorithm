package HeapAndPriorityQueue;

import java.util.*;
public class NearlySorted {

    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // MinHeap
        int n = arr.length;

        // Step 1: Insert first k+1 elements
        for (int i = 0; i <= k && i < n; i++) {
            pq.add(arr[i]);
        }

        int index = 0;

        // Step 2: Process remaining elements
        for (int i = k + 1; i < n; i++) {
            arr[index++] = pq.poll(); // extract smallest
            pq.add(arr[i]);           // add next element
        }

        // Step 3: Extract remaining heap elements
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        System.out.println("Original array: " + Arrays.toString(arr));

        nearlySorted(arr, k);

        System.out.println("Sorted array:   " + Arrays.toString(arr));
    }
}
