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
    public ArrayList<Integer> rightView(Node root){
        ArrayList<Integer> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                Node curr = q.remove();

                if(i == size-1){
                    result.add(curr.data);
                }

                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
        }
        return result;
    }
}