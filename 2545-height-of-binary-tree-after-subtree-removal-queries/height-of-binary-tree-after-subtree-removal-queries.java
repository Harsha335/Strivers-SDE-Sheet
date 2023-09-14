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
    HashMap<Integer,Integer> level=new HashMap<>();
    HashMap<Integer,int[][]> levelMax=new HashMap<>();
    int height(TreeNode root,int lev)
    {
        if(root==null)return 0;
        level.put(root.val,lev);
        int lefty=height(root.left,lev+1);
        int righty=height(root.right,lev+1);
        int height=1+Math.max(lefty,righty);
        levelMax.putIfAbsent(lev,new int[2][2]);
        if(height>levelMax.get(lev)[0][0])
        {
            int cur[][]=levelMax.get(lev);
            cur[1]=cur[0].clone();
            cur[0][0]=height;
            cur[0][1]=root.val;
            levelMax.put(lev,cur);
        }
        else if(height>levelMax.get(lev)[1][0])
        {
            int cur[][]=levelMax.get(lev);
            cur[1][0]=height;
            cur[1][1]=root.val;
            levelMax.put(lev,cur);
        }
        return height;
    }
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n=queries.length;
        int height=height(root,0);
        // System.out.println(height);
        int output[]=new int[n];
        int ind=0;
        for(int x:queries)
        {
            int lev=level.get(x);
            // System.out.println(x+"-"+lev+" "+levelMax.get(lev)[0][0]+"-"+levelMax.get(lev)[0][1]+" "+levelMax.get(lev)[1][0]+"-"+levelMax.get(lev)[1][1]);
            if(levelMax.get(lev)[0][1]==x)
            {
                output[ind++]=height-levelMax.get(lev)[0][0]+levelMax.get(lev)[1][0]-1;
            }
            else{
                output[ind++]=height-1;
            }
        }
        return output;
    }
}