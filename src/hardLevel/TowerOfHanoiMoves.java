package hardLevel;

public class TowerOfHanoiMoves {

    // Recursive method to calculate total moves
    public static int totalMoves(int n) {
        if (n == 1) {
            return 1; // Base case
        }
        return 2 * totalMoves(n - 1) + 1;
    }

    public static void main(String[] args) {
        int n = 3; // You can change this value for more disks

        int moves = totalMoves(n);

        System.out.println("Total moves required to solve Tower of Hanoi with " + n + " disks: " + moves);
    }
}

