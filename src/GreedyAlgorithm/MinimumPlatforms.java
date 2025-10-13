package GreedyAlgorithm;

import java.util.*;
public class MinimumPlatforms {
        public static int findPlatform(int[] arr, int[] dep, int n) {
            // Step 1: Sort arrival and departure times
            Arrays.sort(arr);
            Arrays.sort(dep);

            int i = 0, j = 0;
            int platforms_needed = 0;
            int max_platforms = 0;

            // Step 2: Traverse both arrays
            while (i < n && j < n) {
                if (arr[i] <= dep[j]) {
                    // New train arrives before last one departs
                    platforms_needed++;
                    i++;
                } else {
                    // Train departs, free a platform
                    platforms_needed--;
                    j++;
                }
                max_platforms = Math.max(max_platforms, platforms_needed);
            }

            return max_platforms;
        }

        public static void main(String[] args) {
            int[] arr = {900, 940, 950, 1100, 1500, 1800};
            int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
            int n = arr.length;

            System.out.println("Minimum number of Platforms required = " + findPlatform(arr, dep, n));
        }
}


   // Sorting arrivals & departures → O(n log n)

        //Two-pointer traversal → O(n)
       // ✅ Total: O(n log n)