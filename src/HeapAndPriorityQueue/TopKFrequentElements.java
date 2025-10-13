package HeapAndPriorityQueue;

import java.util.*;
public class TopKFrequentElements {

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min-heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> freqMap.get(a) - freqMap.get(b)
        );

        for (int num : freqMap.keySet()) {
            pq.add(num);
            if (pq.size() > k) pq.poll(); // remove least frequent
        }

        // Step 3: Extract top k frequent elements
        int[] result = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
