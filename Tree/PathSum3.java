package Tree;

import java.util.HashMap;

public class PathSum3 {
	static int res=0;
	static void getPathSum(TreeNode root, int target) {
		HashMap<Integer, Integer> map= new HashMap<>();
		hasSum(root, target, 0, map);
		map.put(0, 1);
//		return res;
		System.out.println(res);
	}
	
	static void hasSum(TreeNode root, int target, int curr_sum, HashMap<Integer, Integer> map) {
		if(root == null) return;
		
		curr_sum += root.data;
		
		if(map.containsKey(curr_sum - target)) res += map.get(curr_sum - target);
		
		map.put(curr_sum, map.getOrDefault(curr_sum, 0) + 1);
		
		hasSum(root.left, target, curr_sum, map);
		hasSum(root.right, target, curr_sum, map);
		
		//BackTrack
		map.put(curr_sum, map.get(curr_sum) - 1);
		return;
		
		
		
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(10);
		root.left= new TreeNode(5);
		root.right= new TreeNode(-3);
		root.left.left= new TreeNode(3);
		root.left.right= new TreeNode(2);
		root.left.left.left= new TreeNode(3);
		root.left.left.right= new TreeNode(-2);
		root.left.right.right= new TreeNode(1);
		
		root.right.right= new TreeNode(11);
		int target= 8;
		getPathSum(root, target);
		
	}
}
