package Codes.BinarySearchTree;

public class IsBST {
    final  static int min=Integer.MIN_VALUE, max= Integer.MAX_VALUE;
    static boolean isBST(Node root, int min, int max){
        if(root==null)
            return true;
        return (root.key>min && root.key<max && isBST(root.left, min, root.key) && isBST(root.right, root.key, max));

    }
    public static void main(String[] args) {
        Node root= new Node(80);
        root.left=new Node(70);
        root.left.left= new Node(60);
        root.left.right= new Node(75);
        root.right= new Node(90);
        root.right.left=new Node(85);
//        root.right.left=new Node(79); //check for false
        root.right.right= new Node(100);

        System.out.println(isBST(root, min, max));
    }
}
