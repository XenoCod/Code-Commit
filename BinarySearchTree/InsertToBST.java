package Codes.BinarySearchTree;

class TreeTraversal{
    public static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.key+" ");
            inOrder(root.right);
        }
    }

    public static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.key+" ");
            inOrder(root.left);
            inOrder(root.right);
        }
    }

    public static void postOrder(Node root){
        if(root!=null){

            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.key+" ");
        }
    }


}



public class InsertToBST {
    static Node insert(Node root, int key){
        if(root==null)
            return  new Node(key);
        else if(root.key>key)
            root.left=insert(root.left, key);
        else
            root.right= insert(root.right, key);
        return root;

    }

    public static void main(String[] args) {
        Node root= new Node(15);
        root.left= new Node(5);
        root.left.left= new Node(3);
        root.right= new Node(20);
        root.right.left= new Node(18);
        root.right.right= new Node(80);
        root.right.left.left= new Node(16);
        int key=19;
        root=insert(root, key);
        new TreeTraversal().inOrder(root);
        System.out.println();
        new TreeTraversal().preOrder(root);
        System.out.println();
        new TreeTraversal().postOrder(root);


    }
}
