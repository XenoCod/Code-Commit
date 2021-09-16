package Tree;

import java.util.ArrayList;

public class ChildrenSumPropertyTree {
	static void childSum(TreeNode root) {
		//While going down is the left + right < parent then make the left = parent value and right = parent value
		//While coming back if the left + right > parent make the parent = left + right sum value
		if(root == null) return;
		int child=0;
		if(root.left != null) child += root.left.data;
		if(root.right !=  null) child += root.right.data;
		
		if(child >= root.data) root.data= child;
		
		else {
			if(root.left != null) root.left.data= child;
			else if(root.right != null) root.right.data=child;
		}
		
		childSum(root.left);
		childSum(root.right);
		
		//Backtrack
		int tot=0;
		if(root.left != null ) tot+= root.left.data;
		if(root.right != null) tot+= root.right.data;
		if(root.left != null || root.right != null) root.data= tot;
		
		}
	
	static void printPath(TreeNode root, ArrayList<String> list, StringBuilder sb) {
		if(root == null) return;
		
		int len= sb.length();
		sb.append(root.data);
		//case when we get the result
		if(root.left == null && root.right == null) list.add(sb.toString());
		
		else {
			sb.append("->");
			printPath(root.left, list, sb);
			printPath(root.right, list, sb);
		}
		
		//backtrack then decresase the size
		sb.setLength(len);
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(20);
        root.left=new TreeNode(8);
        root.right= new TreeNode(12);
        root.left.left= new TreeNode(3);
        root.left.right= new TreeNode(5);
        ArrayList<String> list= new ArrayList<>();
        childSum(root);
        printPath(root, list, new StringBuilder());
        System.out.println(list);
	}
}
