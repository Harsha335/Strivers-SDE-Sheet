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
    TreeNode helper(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null) return null;
        if(p.val<=root.val && q.val>=root.val) return root;
        if(p.val<root.val)
        return helper(root.left,p,q);
        else
        return helper(root.right,p,q);

    }
    public TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if(q.val<p.val)
        {
            TreeNode temp=p;
            p=q;
            q=temp;
        }
        return helper(root,p,q);
    }
}