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
    HashMap<Integer,Integer> index;
    TreeNode helper(int ind,int l,int r,int[] inorder,int[] postorder)
    {
        if(l>r || ind<0)
            return null;
        // System.out.println(ind+" "+l+" "+r);
        TreeNode root=new TreeNode(postorder[ind]);
        int indi=index.get(postorder[ind]);
        root.left=helper(ind-1-(r-indi),l,indi-1,inorder,postorder);
        root.right=helper(ind-1,indi+1,r,inorder,postorder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=new HashMap<>();
        int n=inorder.length;
        for(int i=0;i<n;i++)
        {
            index.put(inorder[i],i);
        }
        return helper(n-1,0,n-1,inorder,postorder);
    }
}