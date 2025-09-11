import java.util.*;

public class TargetSumPairs {

    public static List<List<Integer>> findPairsWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();
        Set<List<Integer>> result = new HashSet<>();

        for (int a : arr) {
            int b = target - a;  // because a + b = target → b = target - a

            if (seen.contains(b)) {
                List<Integer> pair = Arrays.asList(Math.min(a, b), Math.max(a, b));
                result.add(pair);  // ensure uniqueness and order
            }

            seen.add(a);  // mark current number as seen
        }

        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int[] arr = {-2, 4, -1, 3, 2, 9};
        int target = 7;

        List<List<Integer>> pairs = findPairsWithSum(arr, target);
        System.out.println(pairs);  // Output: [[-2, 9], [-1, 8], [4, 3]]
    }
}
