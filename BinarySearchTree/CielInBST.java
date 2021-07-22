package Codes.BinarySearchTree;

public class CielInBST {
    static Node ceil(Node root, int key){
        Node res=null;
        while(root!=null){
            if(root.key==key)
                return root;
            else if(root.key>key){
                res=root;
                root=root.left;
            }
            else
                root=root.right;
        }
        return res;
    }
    public static void main(String[] args) {
        Node root= new Node(15);
        root.left= new Node(5);
        root.left.left= new Node(3);
        root.right= new Node(20);
        root.right.left= new Node(30);
        root.right.right= new Node(26);
        root.right.left.left= new Node(16);
        int key=24;
        Node res=ceil(root, key);
        System.out.println(res.key);
    }
}
