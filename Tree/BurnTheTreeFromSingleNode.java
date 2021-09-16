package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BurnTheTreeFromSingleNode {
	
	//Similar to print nodes at distance k with just count the no of times
	
	
	static void mapParents(TreeNode root, Map<TreeNode, TreeNode> parents) {
		Queue<TreeNode> q= new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode curr= q.poll();
			if(curr.left != null) {
				q.add(curr.left);
				parents.put(curr.left, curr);
			}
			
			if(curr.right != null) {
				q.add(curr.right);
				parents.put(curr.right, curr);
			}
		}
	}
    
    
    
	static void BurnTree(TreeNode root, TreeNode target) {
		//First map the parents
		Map<TreeNode, TreeNode> parents= new HashMap<>();
		mapParents(root, parents);
		Map<TreeNode, Boolean> visited= new HashMap<>();
		visited.put(target, true);
		Queue<TreeNode> q= new LinkedList<>();
		q.add(target);
		int times=0;
		while(!q.isEmpty()) {
			times++;
			int size= q.size();
			for(int i=0; i<size; i++) {
				TreeNode curr= q.poll();
				if(curr.left != null && visited.get(curr.left) == null) {
					q.add(curr.left);
					visited.put(curr.left, true );
				}
				if(curr.right != null && visited.get(curr.right) == null) {
					q.add(curr.right);
					visited.put(curr.right, true);
				}
				
				TreeNode parent= parents.get(curr);
				if(parent != null && visited.get(parent) == null) {
					q.add(parent);
					visited.put(parent, true);
				}
			}
			
		}
		
		System.out.println(times-1);
        
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode(3);
		root.left.left= new TreeNode(4);
		
		root.left.right=new TreeNode(5);
		root.left.right.left= new TreeNode(7);
		root.left.right.right= new TreeNode(8);
		
		root.right.right= new TreeNode (6);
		root.right.right.right= new TreeNode(9);
		root.right.right.right.right= new TreeNode (10);
		
		TreeNode target= root.left.right.right;
		
		BurnTree(root, target);
		
	}
}
