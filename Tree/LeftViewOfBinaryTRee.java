package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeftViewOfBinaryTRee {
	static void leftView(TreeNode root) {
		Queue<TreeNode> q= new LinkedList<>();
		q.add(root);
		ArrayList<Integer> list= new ArrayList<>();
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0; i<size; i++) {
				TreeNode curr= q.poll();
				if(i== 0) list.add(curr.data);
				if(curr.left!= null) q.add(curr.left);
				if(curr.right != null) q.add(curr.right);
				
			}
			
		}
		System.out.println(list);
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode(3);
		root.left.right= new TreeNode(5);
		root.left.right.left= new TreeNode(10);
		root.right.right = new TreeNode(4);
		leftView(root);
	}
}
