import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution{
    public void helper(Node root, ArrayList<Integer> result, int level){
        if(root == null){
            return;
        }

        if(level == result.size()){
            result.add(root.data);
        }

        helper(root.left, result, level+1);
        helper(root.right, result, level+1);
    }
    public ArrayList<Integer> leftViewBT(Node root){
        ArrayList<Integer> result = new ArrayList<>();

        helper(root, result, 0);

        return result;
    }
}