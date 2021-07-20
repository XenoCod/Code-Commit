package Codes.Tree;

import java.time.chrono.MinguoDate;

public class ConvertBinaryTreeToDoubkyLinkedLists {
    static Node prev=null;
    static Node BTToDLL(Node root){
        if(root==null)return root;

        Node head=BTToDLL(root.left);
        if(prev==null){head=root;}
        else{
            root.left=prev;
            prev.right=root;
        }
        prev=root;
        BTToDLL(root.right);
        return head;
    }
    static void tranverse(Node root){
      while(root!=null){
          System.out.print(root.key+" ");
          root=root.right;
      }
    }
    public static void main(String[] args) {
        Node tree= new Node(10);
        tree.left=new Node(20);
        tree.right=new Node(30);
        tree.right.left=new Node(40);
        tree.right.right=new Node(50);
        tree=BTToDLL(tree);
        tranverse(tree);
    }
}
