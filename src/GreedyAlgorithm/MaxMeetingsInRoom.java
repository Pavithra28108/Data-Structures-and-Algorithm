package GreedyAlgorithm;

import java.util.*;
public class MaxMeetingsInRoom {


    // Helper class to store meeting start and end times
    static class Meeting {
        int start, end;
        Meeting(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static int maxMeetings(int[] start, int[] end, int n) {
        List<Meeting> meetings = new ArrayList<>();

        // Step 1: Store all meetings
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Step 2: Sort by end time (earliest first)
        meetings.sort((a, b) -> a.end - b.end);

        // Step 3: Select meetings
        int count = 0;
        int lastEnd = -1; // track end time of last selected meeting

        for (Meeting m : meetings) {
            if (m.start > lastEnd) { // strictly greater condition
                count++;
                lastEnd = m.end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        int n = start.length;

        System.out.println("Maximum number of meetings: " + maxMeetings(start, end, n));
    }
}


//Sorting: O(n log n)

       // Selection: O(n)
       // Overall: O(n log n)