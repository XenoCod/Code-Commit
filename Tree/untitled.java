/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA= findLCA(root, startValue, destValue);
        StringBuilder left= new StringBuilder();
        StringBuilder right= new StringBuilder();
        fillPath(LCA, startValue, left);
        fillPath(LCA,destValue, right);
        //Since we strat from startVal to lca so we replace every L to U
        for(int i=0; i< left.length(); i++){
            left.setCharAt(i,'U');
        }
        
        return left.append(right).toString();
    }
    
    
    
    private boolean fillPath(TreeNode root, int val, StringBuilder sb){
        if(root == null) return false;
        if(root.val == val) return true;
        //first go to left
        sb.append("L");
        if(fillPath(root.left, val, sb)) return true;
        //if not found on left then backtrack from left
        sb.deleteCharAt(sb.length()-1);
        //go to right
        sb.append("R");
        if(fillPath(root.right, val, sb)) return true;
        //if not found on right then backtrack fromt right
        sb.deleteCharAt(sb.length()-1);
        //if nothing else found then simply retun false
        return false;
    }
    
    public TreeNode findLCA(TreeNode root, int p, int q){
        if(root == null || root.val == p || root.val == q) return root;
        
        TreeNode left= findLCA(root.left, p, q);
        TreeNode right= findLCA(root.right, p, q);
        
        if(left == null) return right;
        else if(right == null) return left;
        else return root;
    }
}