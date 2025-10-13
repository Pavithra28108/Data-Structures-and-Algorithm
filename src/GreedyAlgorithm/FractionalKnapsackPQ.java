package GreedyAlgorithm;

import java.util.*;

public class FractionalKnapsackPQ {

    static class Item {
        int value, weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = (double) value / weight;
        }
    }

    public static double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        PriorityQueue<Item> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(b.ratio, a.ratio)  // max-heap by ratio
        );

        // Step 1: Push all items into PQ
        for (int i = 0; i < val.length; i++) {
            pq.add(new Item(val[i], wt[i]));
        }

        double totalValue = 0.0;
        int remaining = capacity;

        // Step 2: Pick items from PQ
        while (!pq.isEmpty() && remaining > 0) {
            Item item = pq.poll();

            if (item.weight <= remaining) {
                // Take whole item
                totalValue += item.value;
                remaining -= item.weight;
            } else {
                // Take fraction
                totalValue += item.ratio * remaining;
                remaining = 0; // bag full
            }
        }

        return Math.round(totalValue * 1_000_000.0) / 1_000_000.0; // round to 6 decimals
    }

    public static void main(String[] args) {
        int[] val = {60, 100, 120};
        int[] wt = {10, 20, 30};
        int capacity = 50;

        System.out.printf("Maximum value in Knapsack = %.6f\n",
                fractionalKnapsack(val, wt, capacity));
    }
}

  //  Using PQ:

        //nsert all items → O(n log n)

        //Poll items until full → O(n log n)
        //✅ Total: O(n log n)
