package Codes.Tree;

public class PrintNodesAtDistanceK {
    static void printNodes(Node root, int k ){
        if(root==null)
            return;;
        if(k==0)
            System.out.print(root.key+" ");
        else{
            printNodes(root.left,k-1);
            printNodes(root.right,k-1);
        }

    }
    public static void main(String[] args) {
        Node tree= new Node(10);
        tree.left=new Node(20);
        tree.right=new Node(30);
        tree.right.left=new Node(40);
        tree.right.right=new Node(50);
        int k=3;
        printNodes(tree, k);
    }
}
