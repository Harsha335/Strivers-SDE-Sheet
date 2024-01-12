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

public class Solution {
    private int dfs(TreeNode root,int min,int max){
        if(root == null)
            return max-min;
        int left = dfs(root.left, Math.min(root.val,min), Math.max(root.val, max));
        int right = dfs(root.right, Math.min(root.val,min), Math.max(root.val, max));
        return Math.max(left,right);
    }
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }
}

