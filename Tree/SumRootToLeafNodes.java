class SumRootToLeafNodes{

	private int rootToLeaf(int root[]){
		//Base case
        if(root == null) return 0;
        
        return rootToLeafSum(root, new StringBuilder());
	}

	 private int rootToLeafSum(TreeNode root, StringBuilder sb){
        //Base case
        if(root == null) return 0;
        
        //Record the len before adding the curr root val
        int len= sb.length();
        sb.append(root.val);
        int res=0;
        
        //When encounter a leaf node
        if(root.left == null && root.right == null){
            res = Integer.parseInt(sb.toString());
            sb.setLength(len); // backtack by removing the last added root val
            return res;
            
        }
        
        //Add the root val of left & right subtree
        res += rootToLeafSum(root.left, sb);
        res += rootToLeafSum(root.right, sb);
        //backtrack
        sb.setLength(len);
        return res;  
    }



	public static void main(String[] args) {

// Input: root = [1,2,3]
// Output: 25
// Explanation:
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// Therefore, sum = 12 + 13 = 25.

		int root[]={1,2,3};
		rootToLeaf(root);

	}
}