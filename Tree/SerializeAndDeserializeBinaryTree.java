package Codes.Tree;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {
    //Using PreOrder Traversal for simplicity
    static final int EMPTY=-1;
    static int index=0;
    static void serialize(Node root, ArrayList<Integer>nums) {

        if (root == null) {
            nums.add(EMPTY);
            return;
        }
        nums.add(root.key);
        serialize(root.left, nums);
        serialize(root.right, nums);
    }

    static Node deserialize(ArrayList<Integer> nums){
        if(index==nums.size())
            return null;
        int val= nums.get(index);
        index++;
        if(index==EMPTY)
            return  null;
        Node root= new Node(val);
        root.left=deserialize(nums);
        root.right= deserialize(nums);
        return root;
        }

        static void preOrder(Node root){
        if(root==null)
            return ;
            System.out.print(root.key+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    public static void main(String[] args) {
//        serialize = tree=> array/String && deserialize = string/Array => Binary tree
        Node root= new Node(10);
        root.left=new Node(20);
        root.right= new Node(30);
        root.right.left= new Node(60);
        root.right.right= new Node(70);


        root.left.left= new Node(40);
        root.left.right= new Node(50);
        root.left.right.left= new Node(100);

        root.left.left.left= new Node(80);
        root.left.left.right= new Node(90);
        ArrayList<Integer> nums= new ArrayList<>();
        serialize(root,nums);
        System.out.println(nums);
        Node temp= deserialize(nums);
        preOrder(temp);


    }
}
