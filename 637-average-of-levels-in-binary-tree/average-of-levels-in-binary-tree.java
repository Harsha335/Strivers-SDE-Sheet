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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> level=new LinkedList<>();
        level.add(root);
        List<Double> output=new ArrayList<>();
        // output.add((double)root.val);
        double size=1;
        double sum=root.val;
        while(!level.isEmpty())
        {
            size=level.size();
            output.add(sum/size);
            sum=0;
            while(size-->0)
            {
                TreeNode node=level.poll();
                if(node.left!=null)
                {
                    sum+=(double)node.left.val;
                    level.add(node.left);
                }
                if(node.right!=null)
                {
                    sum+=(double)node.right.val;
                    level.add(node.right);
                }
            }
        }
        return output;
    }
}