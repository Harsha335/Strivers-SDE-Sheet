class Solution {
    List<List<Integer>> output;
    int n;
    void swap(List<Integer> cur,int i,int ind)
    {
        int temp=cur.get(i);
        cur.set(i,cur.get(ind));
        cur.set(ind,temp);
    }
    void helper(int ind,List<Integer> cur)
    {
        // System.out.println(ind+" "+cur);
        if(ind==n)
            output.add(new ArrayList<>(cur));
        for(int i=ind;i<n;i++)
        {
            swap(cur,i,ind);
            helper(ind+1,cur);
            swap(cur,i,ind);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        output=new ArrayList<>();
        n=nums.length;
        List<Integer> cur=new ArrayList<Integer>();
        for(int x:nums)
            cur.add(x);
        helper(0,cur);
        return output;
    }
}