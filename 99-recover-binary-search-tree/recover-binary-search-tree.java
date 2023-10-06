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
    HashMap<Integer,TreeNode> map;
    List<Integer> arr;
    void dfs(TreeNode root)
    {
        if(root!=null)
        {
            map.put(root.val,root);
            dfs(root.left);
            arr.add(root.val);
            dfs(root.right);
        }
    }
    public void recoverTree(TreeNode root) {
        map=new HashMap<>();
        arr=new ArrayList<>();
        dfs(root);
        // List<Integer> sorted=new ArrayList<>(arr);
        // Collections.sort(sorted);
        int n=arr.size();
        int first=-1;
        int last=-1;
        boolean isFirst=true;
        for(int i=0;i<n-1;i++)
        {
            if(arr.get(i)>arr.get(i+1))
            {
                if(isFirst)
                {
                    first=arr.get(i);
                    last=arr.get(i+1);
                    isFirst=false;
                }
                else{
                    last=arr.get(i+1);
                }
            }
        }
        if(first==last && first==-1)
            return;
        map.get(first).val=last;
        map.get(last).val=first;
    }
}