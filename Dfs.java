import java.util.*;

class Solution{
    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();

        boolean visited[] = new boolean[adj.size()];

        helper(0, adj, ans, visited);

        return ans;
    }

    public static void helper(int src, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, boolean visited[]){
        visited[src] = true;
        ans.add(src);

        for(int i : adj.get(src)){
            if(!visited[i]){
                helper(i, adj, ans, visited);
            }
        }
    }
}