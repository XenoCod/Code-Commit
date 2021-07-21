package Codes.Tree;


//O(log n * log n) solution
public class CountNodesInCompleteBinaryTree {
    static int countNodes(Node root){
        int lh=0, rh=0;
        Node curr= root;
        while (curr != null) {

            lh++;
            curr=curr.left;
        }
        curr=root;
        while(curr!=null){
            rh++;
            curr=curr.right;
        }
        if(lh==rh)
            return (int)Math.pow(2, lh)-1;
        else
            return 1+countNodes(root.left)+countNodes(root.right);

    }
    public static void main(String[] args) {
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




        System.out.println(countNodes(root));
    }
}
