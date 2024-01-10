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
    private long ans ;
    private long[] dfs(TreeNode root, int start){
        if(root == null){
            return new long[]{0,0};  // height , depth of start
        }
        long left[] = dfs(root.left, start);
        long right[] = dfs(root.right, start);
        // System.out.println(left[0]+" "+right[0]+" "+root.val);
        // System.out.println(left[1]+" "+right[1]);
        if(left[1] != 0){
            ans = Math.max(ans, left[1]+right[0]);
            return new long[]{Math.max(left[0], right[0])+1, left[1]+1};
        }
        if(right[1] != 0){
            ans = Math.max(ans, right[1]+left[0]);
            return new long[]{Math.max(right[0], left[0])+1, right[1]+1};
        }
        if(root.val == start){
            ans = Math.max(left[0], right[0]);
            return new long[]{Math.max(right[0], left[0])+1, 1};
        }
        return new long[]{Math.max(right[0], left[0])+1, 0};
    }
    public int amountOfTime(TreeNode root, int start) {
        ans = 0;
        dfs(root, start);
        return (int)ans;
    }
}