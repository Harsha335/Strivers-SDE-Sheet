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
    int size;
    List<Integer> output;
    private void helper(TreeNode root, int row)
    {
        if(root==null)  return;
        if(size>row)
        {
            output.set(row,Math.max(root.val,output.get(row)));
        }
        else{
            output.add(root.val);
            size++;
        }
        helper(root.left,row+1);
        helper(root.right,row+1);
    }
    public List<Integer> largestValues(TreeNode root) {
        size=0;
        output=new ArrayList<>();
        helper(root,0);
        return output;
    }
}