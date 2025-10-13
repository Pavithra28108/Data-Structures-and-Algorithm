package HeapAndPriorityQueue;
import java.util.*;
public class TopKFrequentOptimized {

    public static int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets, index = frequency
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int num : freqMap.keySet()) {
            int freq = freqMap.get(num);
            buckets[freq].add(num);
        }

        // Step 3: Collect top k frequent elements from high frequency to low
        int[] result = new int[k];
        int index = 0;

        for (int i = nums.length; i >= 0 && index < k; i--) {
            for (int num : buckets[i]) {
                result[index++] = num;
                if (index == k) break; // stop when we have k elements
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }
}
