package Tree;

public class MorrisTraversal {
	static void morris(TreeNode root) {
		TreeNode curr= root;
		TreeNode prev= null;
		while(curr != null) {
			if(curr.left == null) {
				//The final node
				System.out.print(curr.data+" ");
				curr= curr.right;
			}
			else {
				prev= curr.left;
				while(prev.right != null && prev.right != curr) {
					prev=prev.right;// go to last rightmost node in the left subtree
				}
				
				if(prev.right == null) {
					prev.right= curr; //make a thread from the right most node to the the parent node
					curr= curr.left;
				}
				else {
					//prev.right == curr
					prev.right= null;//when we again encounter a thread created we break the thread
					System.out.print(curr.data+" ");
					curr= curr.right;//move to right subtree
					
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.left.right.right= new TreeNode(6);
		root.right= new TreeNode(3);
		
		morris(root);
	}

}
