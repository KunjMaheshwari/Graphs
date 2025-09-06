class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class Solution {
    public boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        return isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max);
    }

    public boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}