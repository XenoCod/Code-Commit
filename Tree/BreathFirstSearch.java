package Codes.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BreathFirstSearch {
    static void depthSearch(Node root){
        if(root==null)return;
        Queue<Node> q=new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node curr=q.poll();
            System.out.print(curr.key+" ");
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
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
        depthSearch(root);

    }
}
