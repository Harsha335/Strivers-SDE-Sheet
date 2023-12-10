class Solution {
    private int power(int x,int n,int mod)
    {
        if(n==0)
            return 1;
        if(n==1)
            return x;
        int ans=power(x,n/2,mod);
        return (int)((((long)ans*ans)%mod)*((n%2==0)?1:x))%mod;
    }
    public int numberOfGoodPartitions(int[] nums) {
        int n=nums.length;
        int countGrp=0;
        HashMap<Integer,Integer> lastInd=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            lastInd.put(nums[i],i);
        }
        int i=0,j=0;
        while(i<n)
        {
            if(i>j)
            {
                countGrp++;
            }
            j=Math.max(j,lastInd.get(nums[i]));
            i++;
        }
        countGrp+=1;
        // System.out.println(countGrp);
        return power(2,countGrp-1,(int)1e9+7);
    }
}