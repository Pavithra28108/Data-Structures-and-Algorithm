public class Segregate0sand1s {

    public static void segregate0and1(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            // Move left forward if it's already 0
            while (left < right && arr[left] == 0) {
                left++;
            }
            // Move right backward if it's already 1
            while (left < right && arr[right] == 1) {
                right--;
            }
            // Swap if left points to 1 and right points to 0
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0, 0, 1};
        segregate0and1(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // Expected output: [0, 0, 0, 0, 1, 1, 1, 1]
    }
}
