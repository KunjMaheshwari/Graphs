class Solution {
    public boolean isCycle(int src, int V, int edges[][], int E, boolean visited[], boolean stack[]) {
        visited[src] = true;
        stack[src] = true;

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (u == src) {
                if (!visited[v] && isCycle(v, V, edges, E, visited, stack)) {
                    return true;
                } else if (stack[v]) {
                    return true;
                }
            }
        }
        stack[src] = false;
        return false;
    }

    public boolean detectCycle(int V, int edges[][]) {
        boolean visited[] = new boolean[V];
        boolean stack[] = new boolean[V];
        int E = edges.length;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                isCycle(i, V, edges, E, visited, stack);
                return true;
            }
        }
        return false;
    }
}