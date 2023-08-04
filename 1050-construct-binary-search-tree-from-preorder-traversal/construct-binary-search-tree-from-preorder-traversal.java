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
    TreeNode helper(int pre[],int low,int high)
    {
        if(low>high) return null;
        if(low==high) return new TreeNode(pre[low]);
        TreeNode root=new TreeNode(pre[low]);
        int uptoPoint=high+1;
        for(int i=low+1;i<=high;i++)
        {
            if(pre[i]>pre[low]){
                uptoPoint=i;
                break;
            }
        }
        root.left=helper(pre,low+1,uptoPoint-1);
        root.right=helper(pre,uptoPoint,high);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,0,preorder.length-1);
    }
}