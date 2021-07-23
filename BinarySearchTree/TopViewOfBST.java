package Codes.BinarySearchTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewOfBST {
    static void topView(Node root){
        Queue<Pair> q= new LinkedList<>();
        TreeMap<Integer, Integer> tm= new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p= q.poll();
            Node curr= p.root;
            int hd= p.hd;
            if(!tm.containsKey(hd))
                tm.put(hd, curr.key);
            if(curr.left!=null)
                q.add(new Pair(curr.left, hd-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right, hd+1));
        }

        for(Map.Entry i:tm.entrySet())
            System.out.print(i.getValue()+" ");
    }
    public static void main(String[] args) {
        Node root= new Node(20);
        root.left= new Node(60);
        root.right=new Node(80);
        root.left.left= new Node(4);
        root.left.right= new Node(10);
        root.right.left= new Node(8);
        root.right.right= new Node(100);
        topView(root);
    }
}
