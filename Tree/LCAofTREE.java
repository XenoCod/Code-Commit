package Tree;

public class LCAofTREE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        //The node at the deppest level is called as lowest commin ancestor
	       //Base case
	        if(root == null || root ==p || root ==q) return root;
	        
	        TreeNode left= lowestCommonAncestor(root.left, p,q);
	        TreeNode right = lowestCommonAncestor(root.right, p,q);
	        
	        if(left == null) return right;
	        else if(right == null) return left;
	        else //we found the result node 
	            return root;
	        
	    

	}

}
