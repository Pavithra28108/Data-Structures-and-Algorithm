package Backtracking;

public class NQueens {

    static int N = 4;

    // Function to print solution
    static void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print((board[i][j] == 1 ? "Q " : ". "));
            System.out.println();
        }
        System.out.println();
    }

    // Check if queen can be placed at board[row][col]
    static boolean isSafe(int board[][], int row, int col) {
        int i, j;

        // Check column above
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper-left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper-right diagonal
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Solve N Queens using backtracking
    static boolean solveNQUtil(int board[][], int row) {
        // base case: all queens placed
        if (row == N) {
            printSolution(board);
            return true; // return true to print all solutions
        }

        boolean res = false;

        // try placing queen in all columns in this row
        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // place queen

                // recur for next row
                res = solveNQUtil(board, row + 1) || res;

                // backtrack
                board[row][col] = 0;
            }
        }

        return res;
    }

    static void solveNQ() {
        int board[][] = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.print("No solution exists");
        }
    }

    public static void main(String args[]) {
        solveNQ();
    }
}
