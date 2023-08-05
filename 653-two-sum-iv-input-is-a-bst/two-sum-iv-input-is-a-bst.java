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
    HashSet<Integer> map;
    boolean helper(TreeNode root,int k)
    {
        if(root==null)
            return false;
        if(map.contains(root.val)) return true;
        map.add(k-root.val);
        if(helper(root.left,k)) return true;
        if(helper(root.right,k)) return true;
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        map=new HashSet<>();
        return helper(root,k);
    }
}