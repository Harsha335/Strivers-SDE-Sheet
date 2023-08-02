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
    TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
    List<List<Integer>> output=new ArrayList<>();
    void helper(TreeNode root,int row,int col){
        if(root!=null){
            map.putIfAbsent(col,new TreeMap<Integer,PriorityQueue<Integer>>());
            map.get(col).putIfAbsent(row,new PriorityQueue<Integer>());
            map.get(col).get(row).add(root.val);
            helper(root.left,row+1,col-1);
            helper(root.right,row+1,col+1);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root,0,0);
        // System.out.println(map);
        for(int key:map.keySet()){
            List<Integer> level=new ArrayList<>();
            for(int x:map.get(key).keySet()){
                // while(!map.get(key).get(x).isEmpty()){
                    PriorityQueue<Integer> xx=map.get(key).get(x);
                    while(!xx.isEmpty())
                        level.add(xx.poll());
                    map.get(key).get(x).poll();
                // }
            }
            output.add(level);
        }
        return output;
    }
}