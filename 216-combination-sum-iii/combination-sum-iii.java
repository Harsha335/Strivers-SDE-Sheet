class Solution {
    List<List<Integer>> output;
    void helper(int visited,int ind,int k,int sum)
    {
        if(k==0 && sum==0)
        {
            List<Integer> curr=new ArrayList<>();
            for(int i=1;i<=9;i++)
            {
                if((visited&(1<<i))!=0)
                {
                    curr.add(i);
                }
            }
            output.add(curr);
            return;
        }
        if(k==0 || sum<=0)
            return;
        for(int i=ind;i<=9;i++)
        {
            helper(visited|(1<<i),i+1,k-1,sum-i);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        output=new ArrayList<>();
        helper(0,1,k,n);
        return output;
    }
}