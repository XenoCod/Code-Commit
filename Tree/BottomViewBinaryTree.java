package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewBinaryTree {
	static void  traverse(TreeNode root) {
		Queue<Pair> q= new LinkedList<>();
		q.add(new Pair(root, 0));
		TreeMap<Integer, Integer> map= new TreeMap<>();
		while(!q.isEmpty()) {
			Pair temp= q.poll();
			TreeNode curr= temp.node;
			int count= temp.count;
			map.put(count,curr.data);
			if(curr.left != null) q.add(new Pair(curr.left, count-1));
			if(curr.right != null) q.add(new Pair(curr.right, count +1));
			
		}
		for(Map.Entry<Integer, Integer> it: map.entrySet()) System.out.println(it.getValue());
		
		
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new TreeNode(3);
		root.right.left= new TreeNode(6);
		root.right.right= new TreeNode(7);
		root.left.left= new TreeNode(4);
		root.left.right= new TreeNode(5);
		root.left.right.left= new TreeNode(8);
		root.left.right.right= new TreeNode(9);
		
				
		traverse(root);
	}
}
