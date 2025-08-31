import java.util.*;

class Solution{
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> ans = new ArrayList<>();
        boolean visited[] = new boolean[adj.size()];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()){
            int curr = q.remove();
            ans.add(curr);
            
            for(int i : adj.get(curr)){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
        return ans;
    }
}