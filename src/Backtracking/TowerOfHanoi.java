package Backtracking;

public class TowerOfHanoi {

    // Function to calculate moves
    public static long countMoves(int n) {
        // Formula: 2^n - 1
        return (long)Math.pow(2, n) - 1;
    }

    public static void main(String[] args) {
        int n = 2; // Example input
        System.out.println("Total moves required: " + countMoves(n));
    }
}
