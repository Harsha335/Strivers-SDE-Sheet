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
    void helper(TreeNode root)
    {
        if(root==null) return;
        helper(root.left);
        helper(root.right);
        if(root.left!=null)
        {
            TreeNode first=root.left;
            TreeNode last=first;
            while(last.right!=null)
                last=last.right;
            root.left=null;
            TreeNode nexty=root.right;
            root.right=first;
            last.right=nexty;
        }
    }
    public void flatten(TreeNode root) {
        helper(root);
        
    }
}