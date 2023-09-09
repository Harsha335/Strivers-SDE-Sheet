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
    int pre,mini;
    void helper(TreeNode root)
    {
        if(root==null) return;
        helper(root.left);
        mini=Math.min(mini,(root.val-pre));
        pre=root.val;
        helper(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        mini=(int)1e5;
        pre=-(int)1e5;
        helper(root);
        return mini;
    }
}