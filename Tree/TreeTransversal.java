package Codes.Tree;

class Node{
    int key;
    Node left, right;
    Node(int k){
        key=k;
    }
}

public class TreeTransversal {
    static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);

        }
    }

    static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.key+ " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    static void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key+" ");
        }
    }
    public static void main(String[] args) {
        Node tree= new Node(10);
        tree.left=new Node(20);
        tree.right=new Node(30);
        tree.right.left=new Node(40);
        tree.right.right=new Node(50);
        inOrder(tree);
        System.out.println();
        preOrder(tree);
        System.out.println();
        postOrder(tree );

    }
}
