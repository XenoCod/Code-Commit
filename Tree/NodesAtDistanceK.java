package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class NodesAtDistanceK {
	
	
	// parents<current node, parent_node>
    static private void markParents(TreeNode root, TreeNode target, Map<TreeNode, TreeNode> parents){
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode curr= q.poll();
            if(curr.left != null){
                parents.put(curr.left, curr);
                q.add(curr.left);
            }
            
            if(curr.right != null){
                parents.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    
	static void nodesAtDistanceK(TreeNode root, TreeNode target, int k) {
		//Go to each node and keep record of its parent to tarverse it while going top
        Map<TreeNode, TreeNode> parents= new HashMap<>();
        markParents(root, target, parents);
        //doing the bfs with going bottom with help of left and right and top with th help of parents
        Queue<TreeNode> q= new LinkedList<>();
        q.add(target);
        int curr_dis=0;
        Map<TreeNode, Boolean> visited= new HashMap<>();//to keep the record of the visited nodes
        visited.put(target, true);
        while(!q.isEmpty()){
            
            int size=q.size();
            if(curr_dis == k) break;
            curr_dis++;
            for(int i=0; i<size; i++){
                TreeNode curr= q.poll();
                //Travesing left
                if(curr.left != null && visited.get(curr.left) == null){
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                //Traversing right
                if(curr.right != null && visited.get(curr.right) == null){
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                //Traversing parent nodes
                TreeNode parent= parents.get(curr);
                if(parent != null && visited.get(parent) == null){
                    q.add(parent);
                    visited.put(parent, true);
                }
            }
        }
        
        List<Integer> list= new ArrayList<>();
        while(!q.isEmpty()) list.add(q.poll().data);
        
//        return list;
        System.out.println(list);
        
	}

	public static void main(String[] args) {
		TreeNode root= new TreeNode(3);
		root.left= new TreeNode(5);
		root.right= new TreeNode(1);
		root.left.left= new TreeNode(6);
		root.left.right= new TreeNode(2);
		root.left.right.left= new TreeNode(7);
		root.left.right.right= new TreeNode(4);
		
		root.right.left= new TreeNode(0);
		root.right.right= new TreeNode(8);
		
		TreeNode  target=root.left;
		int k=2;
		
		nodesAtDistanceK(root, target, k);
		
	}

}
