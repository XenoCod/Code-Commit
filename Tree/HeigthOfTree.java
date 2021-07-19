package Codes.Tree;


public class HeigthOfTree {
    static int height(Node root){
        if(root==null)
            return 0;
        else
            return Math.max(height(root.left), height(root.right))+1;
    }
    public static void main(String[] args) {
        Node tree= new Node(10);
        tree.left=new Node(20);
        tree.right=new Node(30);
        tree.right.left=new Node(40);
        tree.right.right=new Node(50);
        System.out.println(height(tree));
    }
}
