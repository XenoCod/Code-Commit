package Tree;

public class MaxPathSum {
	static int getPathSum(TreeNode root) {
		 //Using the maxHeight and diamter of the tree 
        //Since we cant pass variables with referecnec we pass an array refreneces
        int maxSum[]= new int [1];
        maxSum[0]= Integer.MIN_VALUE;
        maxpathSum(root, maxSum);
        return maxSum[0];
    }
    
    private static int maxpathSum(TreeNode root, int max[]){
        if(root == null) return 0;
        
        int leftSum= Math.max(0, maxpathSum(root.left, max));//If the leftum becomes -ve we take 0 insetad
        int rightSum= Math.max(0, maxpathSum(root.right, max));//If the rightsum becomes -ve we take 0 instead
        
        max[0]= Math.max(max[0], root.data + leftSum + rightSum);
        return root.data + Math.max(leftSum, rightSum);//we always take the max sum betweeen left and right
        
	}
	public static void main(String[] args) {
		TreeNode root= new TreeNode(-10);
		root.left= new TreeNode(9);
		root.right= new TreeNode(20);
		root.right.left= new TreeNode(15);
		root.right.right= new TreeNode(7);
		
		System.out.println(getPathSum(root));
	}

}
