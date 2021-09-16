package Tree;

//import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class SerializeAndDeserializeBinaryTree {
    //Using PreOrder Traversal for simplicity
    static final int EMPTY=-1;
    static int index=0;
    static void serialize(TreeNode root, ArrayList<Integer>nums) {

        if (root == null) {
            nums.add(EMPTY);
            return;
        }
        nums.add(root.data);
        serialize(root.left, nums);
        serialize(root.right, nums);
    }

    static TreeNode deserialize(ArrayList<Integer> nums){
        if(index==nums.size())
            return null;
        int val= nums.get(index);
        index++;
        if(index==EMPTY)
            return  null;
        TreeNode root= new TreeNode(val);
        root.left=deserialize(nums);
        root.right= deserialize(nums);
        return root;
        }

        static void preOrder(TreeNode root){
        if(root==null)
            return ;
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    public static void main(String[] args) {
//        serialize = tree=> array/String && deserialize = string/Array => Binary tree
        TreeNode root= new TreeNode(10);
        root.left=new TreeNode(20);
        root.right= new TreeNode(30);
        root.right.left= new TreeNode(60);
        root.right.right= new TreeNode(70);


        root.left.left= new TreeNode(40);
        root.left.right= new TreeNode(50);
        root.left.right.left= new TreeNode(100);

        root.left.left.left= new TreeNode(80);
        root.left.left.right= new TreeNode(90);
        ArrayList<Integer> nums= new ArrayList<>();
        serialize(root,nums);
        System.out.println(nums);
        TreeNode temp= deserialize(nums);
        preOrder(temp);


    }
}
