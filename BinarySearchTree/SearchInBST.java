package Codes.BinarySearchTree;

class Node{
    int key;
    Node left, right;
    Node(int k){
        key=k;
        left=right=null;
    }

}

public class SearchInBST {
    //Recursive
    static boolean searchRecursive(Node root, int key){
        if (root==null)
            return false;
        if(root.key==key)
            return true;
        else if(root.key<key)
            return searchRecursive(root.right, key);
        else
            return searchRecursive(root.left, key);

    }

    //Iterative
    static boolean searchIterative(Node root, int key){

        while(root!=null){
            if(root.key==key)
                return true;
            else if(root.key<key)
                root=root.right;
            else
                root=root.left;
        }
        return false;
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
//        int key=19;
        System.out.println(searchRecursive(root, key));
        System.out.println(searchIterative(root, key));

    }
}
