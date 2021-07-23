package Codes.BinarySearchTree;

import java.util.*;

class Pair{
    Node root ;
    int hd;
    Pair(Node r, int h ){
        root=r;
        hd=h;
    }

}

public class VerticalTransversalOfBST {
    static void verticalT(Node root){
        Queue<Pair> q= new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>>tm= new TreeMap<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p= q.poll();
            Node curr=p.root;
            int hd=p.hd;
            if(tm.containsKey(hd))
                tm.get(hd).add(curr.key);
            else{
                ArrayList<Integer> al= new ArrayList<>();
                al.add(curr.key);
                tm.put(hd,al);
            }

           if(curr.left!=null)
                q.add(new Pair(curr.left,hd-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right, hd+1));
        }

        //Printing the treeMap
        for(Map.Entry<Integer, ArrayList<Integer>>i:tm.entrySet()){
            ArrayList<Integer>al= i.getValue();
            for(int j:al)
                System.out.print(j+" ");
            System.out.println();
        }


    }
    public static void main(String[] args) {
        Node root= new Node(20);
        root.left= new Node(60);
        root.right=new Node(80);
        root.left.left= new Node(4);
        root.left.right= new Node(10);
        root.right.left= new Node(8);
        root.right.right= new Node(100);
        verticalT(root);
    }
}
