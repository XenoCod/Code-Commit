package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair{
	TreeNode node;
	int count;
	Pair(TreeNode _node, int _count){
		node= _node;
		count= _count;
	}
}

public class TopViewOfTree {
	
	static void traverse(TreeNode root) {
		Queue<Pair>q= new LinkedList<>();
		Map<Integer, Integer> map= new TreeMap<>();
		q.add(new Pair(root, 0));
		while(!q.isEmpty()) {
			Pair curr= q.poll();
			TreeNode temp= curr.node;
			int dis= curr.count;
			if(map.get(dis) == null) map.put(dis, temp.data);
			
			if(temp.left != null)
				q.add(new Pair(temp.left, dis -1));
			
			if(temp.right != null)
				q.add(new Pair(temp.right, dis+1));
			
			
			
		}
		
		for(Map.Entry<Integer, Integer> it: map.entrySet())
			System.out.print( it.getValue()+" ");
		
		
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(1);
		root.left= new TreeNode(2);
		root.right= new  TreeNode (3);
		root.left.left= new TreeNode(4);
		root.left.right=  new TreeNode(5);
		root.left.right.left= new TreeNode(6);
		root.right.right= new TreeNode(7);
		traverse(root);
		
	}

}
