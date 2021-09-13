package Tree;

import java.util.Stack;

class TreeNode{
	TreeNode left, right;
	int data;
	public TreeNode(int _data) {
		data=_data;
	}
}

public class IterativePreOrderTraversal {
	
		void itPreOrder(TreeNode root) {
			Stack<TreeNode> st= new Stack<>();
			//We store the right substree and thne the left s
			st.push(root);
			while(!st.isEmpty()) {
				TreeNode curr= st.pop();
				System.out.println(curr.data);
				if(curr.right != null) st.push(curr.right);
				if(curr.left != null) st.push(curr.left);
				
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
			IterativePreOrderTraversal obj= new IterativePreOrderTraversal();
			obj.itPreOrder(root);
		}
}
