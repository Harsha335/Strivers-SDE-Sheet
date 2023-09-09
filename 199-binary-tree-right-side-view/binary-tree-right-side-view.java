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
    HashMap<Integer,Integer> map;
    int maxlevel;
    void helper(TreeNode root,int level)
    {
        if(root==null)return;
        maxlevel=Math.max(maxlevel,level);
        map.put(level,root.val);
        helper(root.left,level+1);
        helper(root.right,level+1);
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return new ArrayList<>();
        map=new HashMap<>();
        maxlevel=0;
        helper(root,0);
        List<Integer> output=new ArrayList<>();
        for(int i=0;i<=maxlevel;i++)
        {
            output.add(map.get(i));
        }
        return output;
    }
}