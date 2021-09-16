package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerialLizeAndDeSerializeBinaryTree {
	
	static String serialize(TreeNode root) {
		Queue<TreeNode> q= new LinkedList<>();
		q.add(root);
		StringBuilder sb= new StringBuilder();
		while(!q.isEmpty()) {
			TreeNode curr= q.poll();
			if(curr == null) {
				sb.append("n ");
				continue;
			}
			sb.append(curr.data+" ");
			q.add(curr.left);
			q.add(curr.right);
			
		}
		return sb.toString();
		
	}
	
	static private TreeNode  deserialize(String data) {
		Queue<TreeNode> q= new LinkedList<>();
		String vals[]= data.split(" " );
		TreeNode root= new TreeNode(Integer.parseInt(vals[0]));
		q.add(root);
		for(int i=1; i<vals.length; i++) {
			TreeNode parent= q.poll();
			if(!vals[i].equals("n")) {
				TreeNode left= new TreeNode(Integer.parseInt(vals[i]));
				parent.left= left;
				q.add(left);
			}
			if(!vals[++i].equals("n")) {
				TreeNode right= new TreeNode(Integer.parseInt(vals[i]));
				parent.right= right;
				q.add(right);
			}

		}
		
		return root;
		
	}
	
	static private void traverse(TreeNode root) {
		
		if(root == null) return;
		
		System.out.print (root.data);
		
		traverse(root.left);
		traverse(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode(3);
		root.right.left= new TreeNode(4);
		root.right.right = new TreeNode(5);
		
		TreeNode res=deserialize(serialize(root));
		
		traverse(res);
		
	}
}
