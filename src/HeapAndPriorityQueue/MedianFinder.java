package HeapAndPriorityQueue;

import java.util.*;
public class MedianFinder {
    private PriorityQueue<Integer> maxHeap; // smaller half
    private PriorityQueue<Integer> minHeap; // larger half

    public MedianFinder() {
        // Max-heap stores smaller half (in reverse order)
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-heap stores larger half (normal order)
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to maxHeap first
        maxHeap.offer(num);

        // Step 2: Balance so all in maxHeap <= all in minHeap
        minHeap.offer(maxHeap.poll());

        // Step 3: Maintain size property (maxHeap can have 1 extra element)
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();

        mf.addNum(1);
        mf.addNum(2);
        System.out.println("Median after [1, 2]: " + mf.findMedian()); // 1.5

        mf.addNum(3);
        System.out.println("Median after [1, 2, 3]: " + mf.findMedian()); // 2.0

        mf.addNum(5);
        System.out.println("Median after [1, 2, 3, 5]: " + mf.findMedian()); // (2+3)/2 = 2.5

        mf.addNum(4);
        System.out.println("Median after [1, 2, 3, 4, 5]: " + mf.findMedian()); // 3.0
    }
}

//addNum: O(log n)

        //findMedian: O(1)

        //Space: O(n)
