import java.util.*;

class Solution {
    public static void topSortUtil(int curr, boolean visited[], ArrayList<ArrayList<Integer>> ans, Stack<Integer> s) {
        visited[curr] = true;

        for (int neighbour : ans.get(curr)) {
            if (!visited[neighbour]) {
                topSortUtil(neighbour, visited, ans, s);
            }
        }
        s.push(curr);
    }

    public static ArrayList<Integer> topoSort(int edges[][], int V) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            ans.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            ans.get(edge[0]).add(edge[1]);
        }

        boolean visited[] = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topSortUtil(i, visited, ans, s);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!s.isEmpty()) {
            result.add(s.pop());
        }

        return result;
    }
}