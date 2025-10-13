package HeapAndPriorityQueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinHeapImplemantation {
    int[] heap;
    int heapSize;
    MinHeapImplemantation(int size) {
        heap = new int[size];
        heapSize=0;
    }

    int extractMinElement() {
        if(heapSize==0) return -1;

        int topMin = heap[0];
        delete(0);
        return topMin;
    }

    //Replacing with last element and then heapify down
    void delete(int ind) {
        if(heapSize==0 || ind>=heapSize) return;

        heap[ind] = heap[heapSize-1];
        heapSize--;

        topDownHeapify(ind);
    }

    void topDownHeapify(int i) {
        int smallest = i;
        int left=2*i+1, right=2*i+2;

        if(left<heapSize && heap[left]<heap[i]) smallest=left;
        if(right<heapSize && heap[right]<heap[smallest]) smallest=right;

        if(smallest==i) return;

        swap(i, smallest);
        topDownHeapify(smallest);
    }

    void bottomUpheapify(int i) {
        int parent = (i-1)/2;
        if(parent<0 || heap[parent]<heap[i])    return;

        swap(i, parent);
        bottomUpheapify(parent);
    }

    void insert(int val) {
        heap[heapSize++] = val;
        bottomUpheapify(heapSize-1);
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }


    public void heapSort(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); //increase
        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder()); //descreasong

        //buildMinHeap
        MinHeapImplemantation minHeap = new MinHeapImplemantation(n);
        for(int x : arr) minHeap.insert(x);

        while(n>0) {
            System.out.println(minHeap.extractMinElement());
            n--;
        }
    }
}
