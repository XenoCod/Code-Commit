package Tree;

import java.util.ArrayList;

public class BoundaryTraversal {
	
	void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
		TreeNode curr= root;
		while(curr!= null) {
			if(!isLeaf(curr)) res.add(curr.data);
			if(curr.left != null) curr= curr.left;
			else curr= curr.right;
		}
	}
	
	
	void addLeaf(TreeNode root, ArrayList<Integer> res) {
		if(isLeaf(root)) {
			res.add(root.data);
			return;
		}
		
		if(root.left != null) addLeaf(root.left, res);
		if(root.right != null) addLeaf(root.right, res);
	}
	
	
	void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
		TreeNode curr= root;
		ArrayList<Integer> temp= new ArrayList<>();
		while(curr!= null) {
			if(!isLeaf(curr)) temp.add(curr.data);
			if(curr.right != null) curr= curr.right;
			else curr= curr.left;
		}
		
		for(int i=temp.size()-1;i>=0; i--) res.add(temp.get(i));
	}
	
	void traverse(TreeNode root) {
		ArrayList<Integer> res= new ArrayList<>();
		// Alogrithm
		//Travrese the left boundary excluding leaves
		//Travrse the leaf nodes
		//Traverse the right boundary and reverse
		
		addLeftBoundary(root, res);
		addLeaf(root, res);
		addRightBoundary(root, res);
		
		System.out.println(res);
	}
	
	private boolean isLeaf(TreeNode root) {
		if(root.left == null && root.right == null) return true;
		return false;
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode(7);
		root.left.left= new TreeNode(3);
		root.left.left.right= new TreeNode(4);
		root.left.left.right.left= new TreeNode(5);
		root.left.left.right.right= new TreeNode(6);
		
		root.right.right= new TreeNode(8);
		root.right.right.left= new TreeNode(9);
		root.right.right.left.left= new TreeNode(10);
		root.right.right.left.right= new TreeNode(11);
		
		//Anticlockwise boundary traversal
		BoundaryTraversal obj= new BoundaryTraversal();
		obj.traverse(root);
		
	}
}
