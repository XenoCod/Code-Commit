package Codes.BinarySearchTree;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumOfBST {
    static void verticalSum(Node root, int hdist, TreeMap<Integer, Integer>tm){
        if(root==null)
            return;
        verticalSum(root.left, hdist-1, tm);
        int sum=tm.get(hdist)==null?0:tm.get(hdist);
        tm.put(hdist, sum+root.key);
        verticalSum(root.right, hdist+1, tm);
    }
    static void vSum(Node root){
        TreeMap<Integer, Integer> tm= new TreeMap<>();
        verticalSum(root,0, tm);
        for(Map.Entry s:tm.entrySet())
            System.out.print(s.getValue()+" ");

    }
    public static void main(String[] args) {
        Node root= new Node(20);
        root.left= new Node(60);
        root.right=new Node(80);
        root.left.left= new Node(4);
        root.left.right= new Node(10);
        root.right.left= new Node(8);
        root.right.right= new Node(100);
        vSum(root);

    }
}
