public class MajorityElement {

    // Function to find the majority element

    //Boyer-Moore Voting Algorithm
    public static int majorityElement(int[] nums) {
        int candidate = -1;
        int votes = 0;

        // Step 1: Find potential candidate
        for (int num : nums) {
            if (votes == 0) {
                candidate = num;
                votes = 1;
            } else if (num == candidate) {
                votes++;
            } else {
                votes--;
            }
        }

        // Step 2: Verify candidate
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3};
        int result = majorityElement(arr);

        if (result != -1) {
            System.out.println("Majority element is: " + result);
        } else {
            System.out.println("No majority element found.");
        }
    }
}
