import java.util.*;

class Solution {

    public static String findOrder(String words[], int k) {

        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Build graph by comparing adjacent words
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int minLen = Math.min(w1.length(), w2.length());

            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
                    break; // only the first mismatch matters
                }
            }
        }

        // Step 3: DFS Topological Sort
        boolean[] visited = new boolean[k];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        // Step 4: Build answer from stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) (stack.pop() + 'a'));
        }

        return sb.toString();
    }

    private static void dfs(int node, List<List<Integer>> adj,
                            boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}
