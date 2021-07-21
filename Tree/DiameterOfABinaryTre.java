package Codes.Tree;

public class DiameterOfABinaryTre {
    static int res=0;
    static int diameter(Node root){
            if(root==null)
                return 0;

                int lh=diameter(root.left);
                int rh=diameter(root.right);
                res=Math.max(res,lh+rh+1 );
                return 1+Math.max(lh,rh);



    }

    public static void main(String[] args) {
//        Node root= new Node(10);
//        root.left=new Node(20);
//        root.right= new Node(60);
//        root.left.left= new Node(30);
//        root.left.right= new Node(80);
//        root.left.right.right= new Node(90);
//        root.left.right.right.right= new Node(18);
//        root.left.left.left= new Node(40);
//        root.left.left.left.left= new Node(60);
//        root.left.left.right= new Node(80);
        Node root=new Node(10);
        root.left=new Node(20);
        root.right=new Node(30);
        root.right.left=new Node(40);
        root.right.right=new Node(60);
        root.right.left.left=new Node(50);
        root.right.right.right=new Node(70);
        diameter(root);
        System.out.println(res);

    }
}
