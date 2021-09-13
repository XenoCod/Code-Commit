package Tree;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePostOrder {
	ArrayList<Integer> traverse(TreeNode root) {
		//Using one stack
		Stack<TreeNode> st1 = new Stack<TreeNode>(); 
        ArrayList<Integer> postOrder = new ArrayList<Integer>();
        
        if(root == null) return postOrder; 
        
        TreeNode current = root;  
        while(current != null || !st1.isEmpty()) {
            if(current != null){
                st1.push(current);
                current = current.left;
            }else{
                TreeNode temp = st1.peek().right;
                if (temp == null)/* this condition becomes true when right most node isv visted*/ {
                    temp = st1.pop();
                    postOrder.add(temp.data);//head
                    while (!st1.isEmpty() && temp == st1.peek().right) {
                        temp = st1.pop();
                        postOrder.add(temp.data);//right
                    }
                } else {
                    current = temp;
                }
            }
        }
      
        return postOrder; 
		}
		
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode (7);
		root.left.left= new TreeNode (3);
		root.left.right= new TreeNode (4);
		root.left.right.left= new TreeNode(5);
		root.left.right.right= new TreeNode(6);
		IterativePostOrder obj= new IterativePostOrder();
		System.out.println(obj.traverse(root));
	}

}
