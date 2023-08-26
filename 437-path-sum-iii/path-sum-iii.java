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
    HashMap<Long,Integer> map;
    int helper(TreeNode root,long target,long curr){
        if(root==null) return 0;
        curr+=root.val;
        int ans=map.getOrDefault(curr-target,0);
        // System.out.println(map+" "+(curr-target));
        map.put(curr,map.getOrDefault(curr,0)+1);
        ans+=helper(root.left,target,curr)+helper(root.right,target,curr);
        map.put(curr,map.get(curr)-1);
        return ans;
    }
    public int pathSum(TreeNode root, int target) {
        map=new HashMap<>();
        map.put(0l,1);
        return helper(root,target,0);
    }
}