package Codes.BinarySearchTree;

import static Codes.BinarySearchTree.TreeTraversal.inOrder;

public class SwapTwoIncorrectBSTNode {
    static Node prev=null, first=null, second=null;
    static void fixBST(Node root){
        if(root==null)
            return;
        fixBST(root.left);
        if(prev!=null && root.key< prev.key){
            if(first==null)
                first=prev;
            second=root;
        }
        prev=root;
        fixBST(root.right);

    }
    public static void main(String[] args) {
        Node root= new Node(20);
        root.left= new Node(60);
        root.right=new Node(80);
        root.left.left= new Node(4);
        root.left.right= new Node(10);
        root.right.left= new Node(8);
        root.right.right= new Node(100);
        inOrder(root);
        fixBST(root);
        System.out.println();
        int temp=first.key;
        first.key=second.key;
        second.key=temp;
        inOrder(root);



    }
}
