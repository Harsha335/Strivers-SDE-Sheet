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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null)return new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        List<List<Integer>> output=new ArrayList<>();
        ArrayList<Integer> cur=new ArrayList<>();
        cur.add(root.val);
        // output.add((ArrayList)cur.clone());
        while(!q.isEmpty())
        {
            int size=q.size();
            output.add((ArrayList)cur.clone());
            cur.clear();
            while(size-->0)
            {
                TreeNode node=q.poll();
                if(node.left!=null)
                {
                    q.add(node.left);
                    cur.add(node.left.val);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                    cur.add(node.right.val);
                }
            }
        }
        return output;
    }
}