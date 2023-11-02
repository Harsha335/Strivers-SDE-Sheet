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
    int output;
    int [] dfs(TreeNode root)
    {
        if(root==null)
            return new int[]{0,0};
        if((root.left==null && root.right==null))
        {
            output++;
            return new int[]{root.val,1};
        }
        int l[]=dfs(root.left);
        int r[]=dfs(root.right);
        int sum=root.val+l[0]+r[0];
        int count=l[1]+r[1]+1;
        if((sum)/(count)==root.val)
            output++;
        return new int[]{sum,count};
    }
    public int averageOfSubtree(TreeNode root) {
        output=0;
        dfs(root);
        return output;
    }
}