class Solution{
    public static void helper(int image[][], int sr, int sc, int color, int originalColor, boolean visited[][]){
        // base case
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || visited[sr][sc] || originalColor != image[sr][sc]){
            return;
        }

        // updating the vertext and image
        visited[sr][sc] = true;
        image[sr][sc] = color;


        // left 
        helper(image, sr, sc-1, color, originalColor, visited);


        // right 
        helper(image, sr, sc+1, color, originalColor, visited);


        // top
        helper(image, sr-1, sc, color, originalColor, visited);


        // dowm 
        helper(image, sr+1, sc, color, originalColor, visited);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color){
        boolean visited[][] = new boolean[image.length][image[0].length];

        int originalColor = image[sr][sc];

        if(originalColor != color){
            helper(image, sr, sc, color, originalColor, visited);
        }
        return image;
    }
}