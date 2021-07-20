package Codes.Tree;

public class BalancedTrees {
    static int checkBalanced(Node root){
        if(root==null)
            return 0;
        int lsubTree=checkBalanced(root.left);
        if(lsubTree==-1)
            return -1;
        int rsubTres=checkBalanced(root.right);
        if(rsubTres==-1)
            return -1;
        if(Math.abs(lsubTree-rsubTres)>1)
            return -1;
        else
            return Math.max(lsubTree,rsubTres)+1;
    }
    public static void main(String[] args) {
        Node root= new Node(18);
        root.left= new Node(4);
        root.right= new Node(20);
        root.right.left= new Node(13);
        root.right.right= new Node(70);
        root.right.left= new Node(70);
//        root.right.left.right= new Node(70);
        System.out.println((checkBalanced(root)!=-1)?"Balanced":"Not balanced");
    }
}
