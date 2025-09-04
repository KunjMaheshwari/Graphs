import java.util.*;

class Solution {
    public static void dfs1(Stack<Integer> s, boolean visited[], ArrayList<ArrayList<Integer>> ans, int curr) {
        visited[curr] = true;

        for (int i : ans.get(curr)) {
            if (!visited[i]) {
                dfs1(s, visited, ans, i);
            }
        }
        s.push(curr);
    }

    public static void dfs2(int node, boolean visited[], ArrayList<ArrayList<Integer>> transposed){
        visited[node] = true;

        for(int i : transposed.get(node)){
            if(!visited[i]){
                dfs2(i, visited, transposed);
            }
        }
    }

    public static int sol(int V, ArrayList<ArrayList<Integer>> ans) {

        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(s, visited, ans, i);
            }
        }

        ArrayList<ArrayList<Integer>> transposed = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            transposed.add(new ArrayList<>());
        }

        for (int u = 0; u < V; u++) {
            for (int v : ans.get(u)) {
                transposed.get(v).add(u);
            }
        }

        Arrays.fill(visited, false);
        int count = 0;

        while(!s.isEmpty()){
            int node = s.pop();

            if(!visited[node]){
                dfs2(node, visited, transposed);
                count++;
            }
        }

        return count;

    }
}