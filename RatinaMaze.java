import java.util.*;

class Solution {

    public void helper(int maze[][], boolean visited[][], String ans, int row, int col, int n,
            ArrayList<String> result) {
        if (row < 0 || col < 0 || maze[row][col] == 0 || row >= n || col >= n || visited[row][col]) {
            return;
        }

        if (row == n - 1 && col == n - 1) {
            result.add(ans);
            return;
        }
        visited[row][col] = true;

        helper(maze, visited, ans + "L", row, col - 1, n, result);
        helper(maze, visited, ans + "D", row + 1, col, n, result);
        helper(maze, visited, ans + "R", row, col + 1, n, result);
        helper(maze, visited, ans + "U", row - 1, col, n, result);

        visited[row][col] = false;
    }

    public ArrayList<String> ratInMaze(int maze[][]) {
        ArrayList<String> result = new ArrayList<>();
        int n = maze.length;

        boolean visited[][] = new boolean[n][n];

        if (maze[0][0] == 1) {
            helper(maze, visited, "", 0, 0, n, result);
        }
        return result;
    }
}