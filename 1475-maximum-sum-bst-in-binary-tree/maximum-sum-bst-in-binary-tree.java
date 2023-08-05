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
    int maxSum;
    class Pair{
        boolean isBST;
        int min;
        int max;
        int sum;
        Pair(boolean isBST,int min,int max,int sum)
        {
            this.isBST=isBST;
            this.min=min;
            this.max=max;
            this.sum=sum;
        }
    }
    Pair helper(TreeNode root)
    {
        if(root==null) return (new Pair(true,-(int)1e5,(int)1e5,0));
        Pair lefty=helper(root.left);
        Pair righty=helper(root.right);
        if(lefty.isBST && righty.isBST)
        {
            if((lefty.max==(int)1e5 || lefty.max<root.val) && (righty.min==-(int)1e5 || righty.min>root.val))
            {
                maxSum=Math.max(maxSum,lefty.sum+righty.sum+root.val);
                return (new Pair(true,lefty.min==-(int)1e5?root.val:lefty.min,righty.max==(int)1e5?root.val:righty.max,lefty.sum+righty.sum+root.val));
            }
        }
        return (new Pair(false,-(int)1e5,(int)1e5,0));
    }
    public int maxSumBST(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        helper(root);
        return Math.max(0,maxSum);
    }
}