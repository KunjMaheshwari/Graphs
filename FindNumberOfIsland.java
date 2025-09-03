import java.util.*;

class Solution {
    public static boolean isValid(int newRow, int newCol, int n, int m) {
        if (newRow < 0 || newRow >= n) {
            return false;
        }
        if (newCol < 0 || newCol >= m) {
            return false;
        }

        return true;
    }

    public static void bfs(int i, int j, boolean visited[][], char grid[][]) {
        visited[i][j] = true;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { i, j });

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()) {
            int curr[] = q.remove();

            int row = curr[0];
            int col = curr[1];

            for (int delRow = -1; delRow <= 1; delRow++) {
                for (int delCol = -1; delCol <= 1; delCol++) {
                    int newRow = row + delRow;
                    int newCol = col + delCol;

                    if (isValid(newRow, newCol, n, m)
                            && grid[newRow][newCol] == '1'
                            && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;

                        q.add(new int[] { newRow, newCol });
                    }
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean visited[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return count;
    }
}
