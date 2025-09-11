package Backtracking;

public class RatMazeSimple {


    static int N;

    // Check if move is valid
    static boolean isSafe(int x, int y, int[][] maze, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N &&
                maze[x][y] == 1 && sol[x][y] == 0);
    }

    // Recursive function
    static boolean solveMazeUtil(int x, int y, int[][] maze, int[][] sol) {
        // reached destination
        if (x == N - 1 && y == N - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(x, y, maze, sol)) {
            sol[x][y] = 1; // mark cell as part of solution

            // move down
            if (solveMazeUtil(x + 1, y, maze, sol)) return true;

            // move right
            if (solveMazeUtil(x, y + 1, maze, sol)) return true;

            // backtrack
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    static void solveMaze(int[][] maze) {
        N = maze.length;
        int[][] sol = new int[N][N];

        if (!solveMazeUtil(0, 0, maze, sol)) {
            System.out.println("No solution exists");
        } else {
            printSolution(sol);
        }
    }

    // print the path matrix
    static void printSolution(int[][] sol) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    // main
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        solveMaze(maze);
    }
}
