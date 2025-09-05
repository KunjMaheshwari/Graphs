import java.util.*;

class Solution {
    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.dist - p2.dist;
        }
    }

    public static int[] mainCode(int V, int src, int edges[][]) {
        // Step 1: Build adjacency list
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            graph.get(u).add(new int[]{v, wt});
            graph.get(v).add(new int[]{u, wt}); // remove this if directed graph
        }

        // Step 2: Initialize distances
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: Min-heap (priority queue)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        boolean[] visited = new boolean[V];

        // Step 4: Dijkstra
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            if (visited[u]) continue;
            visited[u] = true;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int wt = edge[1];

                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }

    // Example test
    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {
            {0,1,2}, {0,2,4}, {1,3,7}, {1,2,1},
            {2,4,3}, {3,5,1}, {4,3,2}, {4,5,5}
        };
        int src = 0;
        int[] dist = mainCode(V, src, edges);
        System.out.println(Arrays.toString(dist));
    }
}