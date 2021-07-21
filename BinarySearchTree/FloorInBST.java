package Codes.BinarySearchTree;

public class FloorInBST {
    static Node floor(Node root, int key){
        Node res=null;
        while(root!=null){
            if(root.key==key)
                return root;
            else if(root.key>key)
                root=root.left;
            else{
                res=root;
                root=root.right;
            }

        }
        return res;
    }
    public static void main(String[] args) {
        Node root= new Node(15);
        root.left= new Node(5);
        root.left.left= new Node(3);
        root.right= new Node(20);
        root.right.left= new Node(18);
        root.right.right= new Node(80);
        root.right.left.left= new Node(16);
        int key=24;
        Node res=floor(root, key);
        System.out.println(res.key);
    }
}
