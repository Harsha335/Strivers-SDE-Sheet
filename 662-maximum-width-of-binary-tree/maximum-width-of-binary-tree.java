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
    class Pair{
        TreeNode root;
        int ind;
        Pair(TreeNode root,int ind){
            this.root=root;
            this.ind=ind;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        int diff=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            int startId=q.peek().ind;
            int mini=(int)1e9;
            int maxi=0;
            while(size-->0)
            {
                Pair ele=q.poll();
                int ind=ele.ind-startId; //****************** */
                root=ele.root;
                // if(ele.root==null) continue;
                mini=Math.min(ind,mini);
                maxi=Math.max(ind,maxi);
                if(root.left!=null)q.add(new Pair(root.left,2*ind+1));
                if(root.right!=null)q.add(new Pair(root.right,2*ind+2));
            }
            if(mini==(int)1e9 || maxi==0)continue;
            diff=Math.max(diff,(int)(maxi-mini)+1);
        }
        return diff;
    }
}