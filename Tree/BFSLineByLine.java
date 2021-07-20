package Codes.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSLineByLine {
    static void levelOrder(Node root){
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();
                System.out.print(curr.key+" ");
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.left.left=new Node(8);
        root.left.right=new Node(7);
        root.left.right.left=new Node(9);
        root.left.right.right=new Node(15);

        root.right.right=new Node(6);
        levelOrder(root);
    }
}
