package Codes.BinarySearchTree;

import static Codes.BinarySearchTree.TreeTraversal.inOrder;
import static Codes.BinarySearchTree.TreeTraversal.preOrder;

public class DeleteInBST {
    static Node getSuccesor(Node root){
        Node curr=root.right;
        while(curr!=null && curr.left!=null)
            curr=curr.left;
        return curr;
    }
    static Node delete(Node root, int key){
        if(root==null)
            return null;
        if(root.key>key)
            root.left=delete(root.left, key);
        else if(root.key<key)
            root.right=delete(root.right, key);
        else {
            if(root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;
            else{
                Node succ=getSuccesor(root);
                root.key=succ.key;
                root.right=delete(root.right, succ.key);


            }


        }
        return root;
    }
    public static void main(String[] args) {
        Node root= new Node(15);
        root.left= new Node(5);
        root.left.left= new Node(3);
        root.right= new Node(20);
        root.right.left= new Node(18);
        root.right.right= new Node(80);
        root.right.left.left= new Node(16);
        int key=16;
        preOrder(root);


        System.out.println();
        root=delete(root, key);
        preOrder(root);
    }
}
