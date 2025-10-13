package GreedyAlgorithm;

import java.util.*;
public class jobSequencing {

    static class Job {
        int deadline, profit;
        Job(int d, int p) {
            deadline = d;
            profit = p;
        }
    }

    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length;
        Job[] jobs = new Job[n];

        // Step 1: Create job objects
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(deadline[i], profit[i]);
        }

        // Step 2: Sort jobs by deadline (ascending)
        Arrays.sort(jobs, (a, b) -> a.deadline - b.deadline);

        // Step 3: Use min-heap to store selected job profits
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Step 4: Process each job
        for (Job job : jobs) {
            pq.offer(job.profit); // take this job
            if (pq.size() > job.deadline) {
                pq.poll(); // remove least profitable job if over time slots
            }
        }

        // Step 5: Calculate total profit and job count
        int totalProfit = 0;
        for (int val : pq) totalProfit += val;

        ArrayList<Integer> result = new ArrayList<>();
        result.add(pq.size());     // number of jobs done
        result.add(totalProfit);   // total profit
        return result;
    }

    // Just for local testing
    public static void main(String[] args) {
        jobSequencing s = new jobSequencing();
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};
        System.out.println(s.jobSequencing(deadline, profit)); // [2, 60]
    }
}

   // PQ approach → O(n log n) (heap operations)
   // PQ approach → O(n log n) (heap operations)