import java.util.HashSet;

public class TripletSum {

    public static boolean findTriplet(int[] arr, int target) {
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int first = arr[i];
            int requiredSum = target - first;

            HashSet<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < n; j++) {
                int second = arr[j];
                int third = requiredSum - second;

                if (seen.contains(third)) {
                    // Triplet found
                    System.out.println("Triplet found: " + first + ", " + second + ", " + third);
                    return true;
                }
                seen.add(second);
            }
        }

        System.out.println("No triplet found.");
        return false;
    }

    // Test the function
    public static void main(String[] args) {
        int[] arr = {1, 4, 45, 6, 10, 8};
        int target = 13;

        findTriplet(arr, target);
    }
}
