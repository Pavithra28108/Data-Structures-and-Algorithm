import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MissingNumbers {

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        int min = Collections.min(brr);
        int max = Collections.max(brr);

        int range = max - min + 1;
        int[] freqArr = new int[range];
        int[] freqBrr = new int[range];

        for (int a : arr) {
            freqArr[a - min]++;
        }
        for (int b : brr) {
            freqBrr[b - min]++;
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < range; i++) {
            if (freqBrr[i] > freqArr[i]) {
                missing.add(i + min);
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);

        List<Integer> result = missingNumbers(arr, brr);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
