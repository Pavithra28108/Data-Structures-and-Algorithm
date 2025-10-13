package HeapAndPriorityQueue;

import java.util.*;
public class MaxPriorityQueue {

    private ArrayList<Integer> heap;

    public MaxPriorityQueue() {
        heap = new ArrayList<>();
    }

    // Already implemented push
    public void push(int x) {
        heap.add(x);
        int index = heap.size() - 1;
        bubbleUp(index);
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(parent) < heap.get(index)) {
                swap(parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // Implement pop() → remove and return maximum
    public int pop() {
        if (heap.isEmpty()) return -1;

        int max = heap.get(0); // root
        int last = heap.remove(heap.size() - 1); // last element

        if (!heap.isEmpty()) {
            heap.set(0, last); // replace root
            heapify(0);        // heapify down
        }

        return max;
    }

    private void heapify(int index) {
        int size = heap.size();
        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap.get(left) > heap.get(largest)) largest = left;
        if (right < size && heap.get(right) > heap.get(largest)) largest = right;

        if (largest != index) {
            swap(largest, index);
            heapify(largest);
        }
    }

    // Optional → peek max without removing
    public int peek() {
        if (heap.isEmpty()) return -1;
        return heap.get(0);
    }


    public class Main {
        public static void main(String[] args) {
            MaxPriorityQueue pq = new MaxPriorityQueue();

            pq.push(5);
            pq.push(2);
            pq.push(10);
            pq.push(3);

            System.out.println(pq.pop()); // 10
            System.out.println(pq.pop()); // 5
            System.out.println(pq.pop()); // 3
            System.out.println(pq.pop()); // 2
            System.out.println(pq.pop()); // -1 (empty)
        }
    }
}