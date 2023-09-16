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
    HashMap<TreeNode,Integer> dp;
    // class Data{
    //     TreeNode node;
    //     // boolean took;
    //     Data(TreeNode node,boolean took){
    //         this.node=node;
    //         // this.took=took;
    //     }
    //     @Override
    //     public boolean equals(Object  obj)
    //     {
    //         if (obj == this) {
    //             return true;
    //         }
    //         if (!(obj instanceof Data)) {
    //             return false;
    //         }
    //         Data o = (Data)obj;
    //         return this.node==o.node;// && this.took==o.took;
    //     }
    // }
    int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        // int maxi=0;
        int x=0,y=0,ans1=0;
        // Data current=new Data(root);
        // System.out.println(dp);
        if(dp.containsKey(root)){
            // System.out.println("hi");
            return dp.get(root);
        }
        // if(took==false){
        if(root.left!=null)
            x=helper(root.left.left)+helper(root.left.right);
        if(root.right!=null)
            y=helper(root.right.left)+helper(root.right.right);
        ans1=x+y+root.val;
        // }
        x=helper(root.left);
        y=helper(root.right);
        dp.put(root,Math.max(x+y,ans1));
        return Math.max(x+y,ans1);
    }
    public int rob(TreeNode root) {
        dp=new HashMap<>();
        return helper(root);
    }
}