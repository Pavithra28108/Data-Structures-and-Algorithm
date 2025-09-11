package Backtracking;

public class TowerOfHanoiRecursion {

    // Recursive function to solve Tower of Hanoi
    public static void solve(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from + " to rod " + to);
            return;
        }

        // Step 1: Move n-1 disks from 'from' → 'aux'
        solve(n - 1, from, aux, to);

        // Step 2: Move nth disk from 'from' → 'to'
        System.out.println("Move disk " + n + " from rod " + from + " to rod " + to);

        // Step 3: Move n-1 disks from 'aux' → 'to'
        solve(n - 1, aux, to, from);
    }

    // Function to return number of moves (2^n - 1)
    public static long countMoves(int n) {
        return (1L << n) - 1; // bit shift → same as (long)Math.pow(2, n) - 1
    }

    public static void main(String[] args) {
        int n = 3; // Example: 3 disks
        System.out.println("Total moves required: " + countMoves(n));
        solve(n, '1', '3', '2');  // rods are labeled 1, 2, 3
    }
}
