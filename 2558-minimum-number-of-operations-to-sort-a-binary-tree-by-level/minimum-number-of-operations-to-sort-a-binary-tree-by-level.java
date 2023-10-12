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
    private int swapCount(PriorityQueue<Integer> pq,HashMap<Integer,Integer> index,HashMap<Integer,Integer> value)
    {
        int ind=0;
        int count=0;
        // System.out.println(index+" "+value);
        while(!pq.isEmpty())
        {
            int curr=pq.poll();
            // System.out.println(curr);
            if(index.get(curr)!=ind)
            {
        // System.out.println(ind+" "+index.get(ind));
                value.put(index.get(curr),value.get(ind));
                index.put(value.get(ind),index.get(curr));
                count++;
            }
        // System.out.println(index+" "+value);
            ind++;
        }
        return count;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        int count=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            // List<Integer> arr=new ArrayList<>();
            HashMap<Integer,Integer> index=new HashMap<>();
            HashMap<Integer,Integer> value=new HashMap<>();
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            int ind=0;
            while(size-->0)
            {
                TreeNode node=q.poll();
                if(node.left!=null)
                {
                    q.add(node.left);
                    // arr.add(node.left.val);
                    pq.add(node.left.val);
                    value.put(ind,node.left.val);
                    index.put(node.left.val,ind++);
                }
                if(node.right!=null)
                {
                    q.add(node.right);
                    // arr.add(node.right.val);
                    pq.add(node.right.val);
                    value.put(ind,node.right.val);
                    index.put(node.right.val,ind++);
                }
            }
            count+=swapCount(pq,index,value);
            // System.out.println("\n"+count);
        }
        return count;
    }
}