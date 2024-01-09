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
    private void leafNodes(TreeNode root, List<Integer> list){
        if(root == null)
            return ;
        if(root.left == null && root.right == null)
        {
            list.add(root.val);
            return;
        }
        leafNodes(root.left, list);
        leafNodes(root.right, list);
        
    }
    int ind;
    private boolean checkNodes(TreeNode root, List<Integer> list, int size){
        if(root == null)
        {
            // System.out.println("hi");
            return true;
        }
        if(root.left == null && root.right == null)
        {
            // System.out.println(root.val+" "+ind+" "+size);
            return ind<size && root.val == list.get(ind++);
        }
        return checkNodes(root.left, list, size) && checkNodes(root.right, list, size);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        leafNodes(root1, list);
        // System.out.println(list);
        ind = 0;
        return checkNodes(root2, list, list.size()) && ind == list.size();
    }
}