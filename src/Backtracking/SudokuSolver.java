package Backtracking;

public class SudokuSolver {

    private static final int N = 9;

    // Solve Sudoku using backtracking
    public boolean solve(int[][] board) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 0) { // empty cell
                    for (int num = 1; num <= 9; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true; // recurse
                            board[row][col] = 0; // backtrack
                        }
                    }
                    return false; // no valid number found
                }
            }
        }
        return true; // solved
    }

    // Optimized isSafe: checks row, column, and box
    private boolean isSafe(int[][] board, int row, int col, int num) {
        for (int i = 0; i < N; i++) {
            // check row & col
            if (board[row][i] == num || board[i][col] == num) return false;
        }

        // check 3x3 subgrid using single loop
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int k = 0; k < 9; k++) {
            int r = startRow + k / 3;
            int c = startCol + k % 3;
            if (board[r][c] == num) return false;
        }
        return true;
    }

    // Print Sudoku board
    public static void printBoard(int[][] board) {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }

    // Driver code
    public static void main(String[] args) {
        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        SudokuSolver solver = new SudokuSolver();
        if (solver.solve(board)) {
            System.out.println("Solved Sudoku:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
