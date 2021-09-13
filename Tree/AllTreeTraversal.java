package Tree;

import java.util.ArrayList;
import java.util.Stack;


class Pair{
	int count;
	TreeNode node;
	Pair(TreeNode _node, int _count){
		node =_node;
		count= _count;
	}
}

public class AllTreeTraversal {
	
	static void traverse(TreeNode root, ArrayList<Integer> pre, ArrayList<Integer> in, ArrayList<Integer> post) {
		Stack<Pair> st= new Stack<>();
		st.push(new Pair(root, 1));
		while(!st.isEmpty()) {
			Pair curr= st.pop();
			
			//Algo
			
			/*
			 * if the count is 1 => Root, left, right
			 * then increment the count
			 * add to pre order
			 * if there is left subtree go to the left subtree
			 * 
			 * 
			 * if the count is 2=> left, Root, right
			 * then increment the count 
			 * add to the in order
			 * if there is right subtree go to the right subtree
			 * 
			 * 
			 * if the count is 3 => right, left, root
			 * add to the post order 
			 */
			
			
			if(curr.count == 1) {
				pre.add(curr.node.data);
				curr.count++;
				st.push(curr);
				
				if(curr.node.left != null) {
					st.push(new Pair(curr.node.left, 1));
				}
			}
			
			else if(curr.count == 2) {
				in.add(curr.node.data);
				curr.count++;
				st.push(curr);
				
				if(curr.node.right != null) {
					st.push(new Pair(curr.node.right, 1));
				}
				
			}
			
			else if(curr.count == 3) {
				post.add(curr.node.data);
				
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode (7);
		root.left.left= new TreeNode (3);
		root.left.right= new TreeNode (4);
		root.left.right.left= new TreeNode(5);
		root.left.right.right= new TreeNode(6);
		
		ArrayList<Integer> pre= new ArrayList<>();
		ArrayList<Integer> in= new ArrayList<>();
		ArrayList<Integer> post= new ArrayList<>();
		
		traverse(root, pre, in, post);
		
		System.out.println("Preorder => "+pre);
		System.out.println("Inorder => "+ in);
		System.out.println("PostOrder => "+post);
	}

}
