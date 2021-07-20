package Codes.Tree;

public class ChildrenSumProperty {
    static boolean childSumProp(Node root){
       if(root==null)
           return true;
       if(root.left==null && root.right==null)
           return true;
       int sum=0;
       if(root.left!=null)
           sum+=root.left.key;
       if(root.right!=null)
           sum+=root.right.key;
       return (sum==root.key && childSumProp(root.right) && childSumProp(root.left));
    }
    public static void main(String[] args) {
        Node root= new Node(20);
        root.left=new Node(8);
        root.right= new Node(12);
        root.left.left= new Node(3);
        root.left.right= new Node(5);

        System.out.println(childSumProp(root));
    }
}
