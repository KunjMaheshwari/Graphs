import java.util.*;

class Solution{

    public static String findOrder(String words[], int k){

        //Step 1 - > create a graph
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<k;i++){
            adj.add(new ArrayList<>());
        }
        
        //Step 2 - compare adjacent words
        for(int i=0;i<words.length-1;i++){
            String w1 = words[i];
            String w2 = words[i+1];

            int minLen = Math.min(w1.length(), w2.length());

            for(int j=0;j<minLen;j++){
                if(w1.charAt(j) != w2.charAt(j)){
                    adj.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
                    break;
                }
            }
        }

        //Step 3 - Topological Sorting
        int indegree[] = new int[k];
        for(int u=0;u<k;u++){
            for(int v : adj.get(u)){
                indegree[v]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            if(indegree[i] == 0) q.add(i);
        }

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()){
            int curr = q.remove();

            sb.append((char) (curr + 'a'));

            for(int v : adj.get(curr)){
                indegree[v] --;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        return sb.toString();
    }
}