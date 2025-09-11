package Bitonics;

import java.util.*;
public class SubarraySum {

    public static int countSubarraysWithSum(int[] arr, int tar) {
        HashMap<Integer, Integer> prefixSumFreq = new HashMap<>();
        int count = 0;
        int currentSum = 0;

        prefixSumFreq.put(0, 1);  // sum 0 has occurred once

        for (int num : arr) {
            currentSum += num;

            if (prefixSumFreq.containsKey(currentSum - tar)) {
                count += prefixSumFreq.get(currentSum - tar);
            }

            prefixSumFreq.put(currentSum, prefixSumFreq.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int tar = -10;

        System.out.println("Count of subarrays with sum " + tar + ": " + countSubarraysWithSum(arr, tar));
    }
}
