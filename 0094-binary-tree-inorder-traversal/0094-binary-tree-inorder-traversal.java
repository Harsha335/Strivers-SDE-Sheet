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
    List<Integer> output=new ArrayList<>();
    // void inorder(TreeNode root)
    // {
    //     if(root==null)return ;
    //     inorder(root.left);
    //     output.add(root.val);
    //     inorder(root.right);
    // }
    public List<Integer> inorderTraversal(TreeNode root) {
        // inorder(root);
        
        //ITERATIVE METHOD
        Stack<TreeNode> s=new Stack<>();
        while(!s.isEmpty() || root!=null)
        {
            if(root!=null)
            {
                s.push(root);
                root=root.left;
            }
            else{
                output.add(s.peek().val);
                root=s.pop().right;
            }
        }
        return output;
    }
}