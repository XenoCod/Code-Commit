package Codes.BinarySearchTree;

import java.util.HashSet;

public class IsPairSumInBST {
    static boolean isPairSum(Node root, int sum, HashSet<Integer>nums){
        if(root==null)
            return false;
        if(isPairSum(root.left, sum, nums))
            return true;
        else if(nums.contains(sum-root.key))
            return true;
        else
            nums.add(root.key);
        return isPairSum(root.right,sum, nums);


    }
    public static void main(String[] args) {
        Node root= new Node(20);
        root.left= new Node(60);
        root.right=new Node(80);
        root.left.left= new Node(4);
        root.left.right= new Node(10);
        root.right.left= new Node(8);
        root.right.right= new Node(100);
        int sum=12;
        HashSet<Integer> nums= new HashSet<>();
        System.out.println(isPairSum(root,sum,nums));
    }
}
