class Solution {
    List<List<Integer>> output;
    void helper(int n,int kk,int k,int start,List<Integer> cur)
    {
        if(k==0)
        {
            output.add(new ArrayList<>(cur));
            return;
        }
        for(int i=start;i<=n;i++)
        {
            // if((visited & (1<<i) )==0)
            // {
                cur.add(i);
                helper(n,kk,k-1,i+1,cur);
                // System.out.println(cur+" "+(kk-k));
                cur.remove(kk-k); //index n-k
                // System.out.println(cur+" "+(kk-k));
            // }
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        output=new ArrayList<>();
        helper(n,k,k,1,new ArrayList<>());
        return output;
    }
}