class Solution {
    long maxEle;
    long count;
    int n;
    class Node{
        int data;
        Node left;
        Node right;
        Node(int val)
        {
            this.data=val;
            this.left=null;
            this.right=null;
        }
    }
    public long helper(Node root)
    {
        if(root==null) return 0;
        long l=helper(root.left);
        long r=helper(root.right);
        long curr=Math.max(1,l)*Math.max(1,r)*Math.max(1,n-l-r-1);
        // System.out.println(root.data+" "+l+" "+r+" "+curr);
        if(curr==maxEle)
        {
            count++;
        }
        else if(curr>maxEle){
            maxEle=curr;
            count=1;
        }
        return l+r+1;
    }
    public int countHighestScoreNodes(int[] parents) {
        n=parents.length;
        maxEle=-1;
        count=0;
        Node root=new Node(0);
        HashMap<Integer,Node> map=new HashMap<>();
        map.put(0,root);
        for(int i=1;i<n;i++)
        {
            map.putIfAbsent(parents[i],new Node(parents[i]));
            map.putIfAbsent(i,new Node(i));
            if(map.get(parents[i]).left==null)
            {
                map.get(parents[i]).left=map.get(i);
            }
            else{
                map.get(parents[i]).right=map.get(i);
            }
        }
        helper(root);
        return (int)count;
    }
}