/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode output;
    int helper(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null)return 0;
        int lefty=helper(root.left,p,q);
        int righty=helper(root.right,p,q);
        int cur=(root==p || root==q)?1:0;
        if(lefty+righty+cur>=2){
            output=root;
            return -(int)1e9;
        }
        return lefty+righty+cur; 
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // output;
        helper(root,p,q);
        return output;
    }
}