package Codes.BinarySearchTree;



public class KthSmallestElementInBST {
    static Node insertBST(Node root, int k){
        if(root==null)
            return new Node(k);
        if(root.key>k){
            root.left=insertBST(root.left,k);
            root.lCount++;
        }
        else if(root.key<k)
            root.right=insertBST(root.right, k);

        return root;


    }
    static Node kthSmallest(Node root, int k){
        if(root==null)
            return null;
        int count=root.lCount+1;
        if(count==k)
            return root;
        if(count>k)
            return kthSmallest(root.left, k);
        else
            return kthSmallest(root.right, k-count);
    }
    public static void main(String[] args) {
        Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
        for(int i:keys)
            root=insertBST(root, i);
        int k=4;
        Node res=kthSmallest(root,k);
        System.out.println((res)!=null?res.key:"No such key");
    }
}
