class Solution{
    int v = 4;
    public int countTriangles(boolean isDirected, int graph[][]){
        int count = 0;

        for(int i=0;i<v;i++){
            for(int j=0;j<v;j++){
                for(int k=0;k<v;k++){
                    if(graph[i][j] == 1 && graph[j][k] == 1 && graph[k][i] == 1){
                        count++;
                    }
                }
            }
        }

        if(isDirected == true){
            count = count/3;
        }else{
            count = count/6;
        }
        return count;
    }
}