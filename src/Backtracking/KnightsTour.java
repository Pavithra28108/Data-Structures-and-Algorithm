package Backtracking;

public class KnightsTour {

    static int N = 8; // board size (8x8 chessboard)

    // possible moves for knight
    static int[] rowMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};

    // function to check if move is valid
    static boolean isSafe(int x, int y, int[][] board) {
        return (x >= 0 && x < N && y >= 0 && y < N && board[x][y] == -1);
    }

    // solve Knight's Tour using backtracking
    static boolean solveKnightTour() {
        int[][] board = new int[N][N];

        // initialize board with -1
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = -1;

        // knight starting position
        board[0][0] = 0;

        // start recursive backtracking
        if (!solveUtil(0, 0, 1, board)) {
            System.out.println("No solution exists");
            return false;
        } else {
            printBoard(board);
        }

        return true;
    }

    // recursive utility function
    static boolean solveUtil(int x, int y, int moveCount, int[][] board) {
        if (moveCount == N * N) {
            return true; // all squares visited
        }

        for (int k = 0; k < 8; k++) {
            int nextX = x + rowMoves[k];
            int nextY = y + colMoves[k];

            if (isSafe(nextX, nextY, board)) {
                board[nextX][nextY] = moveCount;

                if (solveUtil(nextX, nextY, moveCount + 1, board)) {
                    return true;
                } else {
                    // backtrack
                    board[nextX][nextY] = -1;
                }
            }
        }
        return false;
    }

    // function to print solution board
    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%2d ", board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveKnightTour();
    }
}
