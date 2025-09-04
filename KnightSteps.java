import java.util.*;

class Solution {

    public static final int[] dx = { -2, -2, -1, -1, 1, 1, 2, 2 };
    public static final int[] dy = { -2, -2, -1, -1, 1, 1, 2, 2 };

    public static int numberOfSteps(int knight[], int target[], int n) {
        int startX = knight[0] - 1;
        int startY = knight[1] - 1;
        int targetX = target[0] - 1;
        int targetY = target[1] - 1;

        if (startX == targetX && startY == targetY) {
            return 0;
        }

        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[n][n];

        visited[startX][startY] = true;

        q.add(new int[] { startX, startY, 0 });

        while (!q.isEmpty()) {
            int curr[] = q.remove();

            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < n && newY < n && !visited[newX][newY]) {
                    if (newX == targetX && newY == targetY) {
                        return steps + 1;
                    }

                    visited[newX][newY] = true;
                    q.add(new int[] { newX, newY, steps + 1 });
                }
            }
        }
        return -1;
    }
}