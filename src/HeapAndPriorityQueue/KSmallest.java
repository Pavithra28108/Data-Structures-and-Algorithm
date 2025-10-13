package HeapAndPriorityQueue;

import java.util.*;
public class KSmallest {
    int findKthSmallest(int[] arr, int k) {
        if (arr.length == 0 || k > arr.length) return -1;

        // Max heap: largest among the k smallest elements is on top
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {
            pq.add(num);             // add element to heap
            if (pq.size() > k) pq.poll(); // remove largest if heap exceeds size k
        }

        // Root of max-heap = kth smallest element
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        int k = 3;

        KSmallest ks = new KSmallest();
        System.out.println("Kth smallest element: " + ks.findKthSmallest(arr, k));
    }
}
