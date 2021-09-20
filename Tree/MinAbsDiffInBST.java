package Tree;

public class MinAbsDiffInBST {
	static void getMin(TreeNode root) {
//		if(root == null) return 0;
        int res[]= new int []{Integer.MAX_VALUE, Integer.MAX_VALUE};
        getMin(root, res);
//        return res[0];
        System.out.println(res[0]);
//         res[0] will store the min
//             and res[1] will store the prev;
        
	}
	
	
	private static void getMin(TreeNode root, int res[]){
        if(root == null) return ;
        
        getMin(root.left, res);
        
        if(res[1] != Integer.MAX_VALUE) res[0]= Math.min(res[0],root.data - res[1] );
        
        res[1]= root.data;
        
        getMin(root.right, res);
        
        // return res[0];
        
    }
	public static void main(String[] args) {
		TreeNode root= new TreeNode(4);
		root.left= new TreeNode(2);
		root.right= new TreeNode(6);
		root.left.left= new TreeNode(1);
		root.left.right= new TreeNode(3);
		
		getMin(root);
	}
}
