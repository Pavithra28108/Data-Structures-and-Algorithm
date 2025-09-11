package Bitonics;

public class PeakElementFinder {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        PeakElementFinder finder = new PeakElementFinder();

        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        int peakIndex = finder.findPeakElement(nums);

        System.out.println("Peak Element Index: " + peakIndex);
        System.out.println("Peak Element Value: " + nums[peakIndex]);
    }
}
