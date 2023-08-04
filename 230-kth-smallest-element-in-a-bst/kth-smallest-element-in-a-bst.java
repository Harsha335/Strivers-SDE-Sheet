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
    int[] helper(TreeNode root,int k)
    {
        if(root==null || k<0) 
            return new int[]{0,-1};  //height,value
        int [] lefty=helper(root.left,k);
        // System.out.println(lefty[0]+" "+lefty[1]+" "+root.val+" "+k);
        if(lefty[1]!=-1)
            return lefty;
        if((lefty[0]+1)==k) 
            return new int[]{lefty[0]+1,root.val};
        int [] righty=helper(root.right,k-lefty[0]-1);
        // System.out.println(righty[0]+" "+righty[1]+" "+root.val+" "+k);
        if(righty[1]!=-1) 
            return righty;
        return new int[]{lefty[0]+righty[0]+1,-1};
    }
    public int kthSmallest(TreeNode root, int k) {
        return helper(root,k)[1];
    }
}