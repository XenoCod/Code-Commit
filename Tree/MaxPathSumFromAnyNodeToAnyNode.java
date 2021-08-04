package Codes.Tree;

public class MaxPathSumFromAnyNodeToAnyNode {
    static int res=Integer.MIN_VALUE;
    static int maxSum(Node root){
        if(root==null) return 0;
        int lh= maxSum(root.left);
        int rh=maxSum(root.right);
        int temp= Math.max(Math.max(lh,rh)+root.key, root.key);
        int ans= Math.max(temp, lh+rh+root.key);
        res=Math.max(res, ans);
        return temp;

    }
    static int maxPathSum(Node root){
        maxSum(root);
        return res;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(10);
        root.left.left = new Node(20);
        root.left.right = new Node(1);
        root.right.right = new Node(-25);
        root.right.right.left = new Node(3);
        root.right.right.right = new Node(4);
        System.out.println(maxPathSum(root));
    }
}
