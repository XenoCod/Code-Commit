package Codes.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfABinaryTree {
    static int maxWidth(Node root){
        if(root==null)
            return 0;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        int res=0;
        while(!q.isEmpty()){
            int count=q.size();
            res=Math.max(res, count);
            for(int i=0;i<count;i++) {
                Node curr = q.poll();
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }

        return res;
    }
    public static void main(String[] args) {
        Node tree= new Node(10);
        tree.left=new Node(20);
        tree.right=new Node(30);
        tree.right.left=new Node(40);
        tree.right.right=new Node(50);
        System.out.println(maxWidth(tree));
    }
}
