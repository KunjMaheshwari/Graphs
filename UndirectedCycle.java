class Solution {
    public boolean isCycleUtils(boolean visited[], int edges[][], int E, int curr, int parent) {
        visited[curr] = true;

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            // case 1
            if (u == curr) {
                if (!visited[v]) {
                    if (isCycleUtils(visited, edges, E, v, curr)) {
                        return true;
                    }
                } else if (v != parent) {
                    return true;
                }
            }
            // case 2
            if (v == curr) {
                if (!visited[u]) {
                    if (isCycleUtils(visited, edges, E, u, curr)) {
                        return true;
                    }
                } else if (u != parent) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, int edges[][]) {
        boolean visited[] = new boolean[V];
        int E = edges.length;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                isCycleUtils(visited, edges, E, i, -1);
                return true;
            }
        }
        return false;
    }
}