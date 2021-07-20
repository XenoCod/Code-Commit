package Codes.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructTreeUsingPreOrderAndInOrder {
    static int preIndex=0;
    static Node constructTree(int in[], int pre[], int indexStart, int indexEnd){

        if(indexStart>indexEnd)
            return null;
        Node root=new Node(pre[preIndex++]);
        int inIndex=indexStart;
        for(int i=indexStart;i<=indexEnd;i++){
            if(in[i]==root.key){
                inIndex=i;
                break;
            }
        }
        root.left=constructTree(in, pre,indexStart, inIndex-1 );
        root.right=constructTree(in, pre, inIndex+1, indexEnd);
        return root;

    }
    static void inOrder(Node root){
      if (root==null)
          return ;
        Queue<Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            for(int i=0;i<count;i++){
                Node curr=q.poll();

                    System.out.print(curr.key+" ");
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int in[]={20, 10, 40,30, 50};
        int pre[]={10,20, 30, 40, 50};
        Node head=constructTree(in , pre, 0, in.length-1);
        inOrder(head);
    }
}
