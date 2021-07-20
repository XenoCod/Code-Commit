package Codes.Tree;

public class MaximmumOfBinaryTree {
    static int maxOfTree(Node root){
        if(root==null)
            return Integer.MIN_VALUE;
        else
            return Math.max(root.key,Math.max(maxOfTree(root.left),maxOfTree(root.right)));
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(80);
        root.left.right=new Node(7);
        root.left.right.left=new Node(9);
        root.left.right.right=new Node(15);
        root.right.right=new Node(6);
        System.out.println(maxOfTree(root));

    }
}
