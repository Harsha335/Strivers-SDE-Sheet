class Solution {
    int n;
    // HashMap<Integer,List<Integer>> map;//store all possible values ele1->ele2,ele2 (%)
    // HashMap<List<Integer>,Integer> buffer;//dp
    // HashMap<Integer,Integer> index;//index of a ele

    int[][] dp;
    int mod=(int)1e9+7;
    public int helper(int nums[],int ind,int mask)
    {
        // System.out.println(last+" "+mask+" "+((1<<n)-1));
        if(mask==((1<<n)-1))
            return 1;
        // if(ind==0)return 0;
        // List<Integer> lis=Arrays.asList(last,mask);
        // if(buffer.containsKey(lis))
        //     return buffer.get(lis);
        if(dp[ind][mask]!=-1)return dp[ind][mask];
        // if(!map.containsKey(last))
        //     return 0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            // int ind=index.get(x);
            if(((1<<i)&mask)==0 && (nums[i]%nums[ind]==0 || nums[ind]%nums[i]==0))
            {
                ans+=helper(nums,i,mask|(1<<i));
                ans=ans%mod;
            }
        }
        // visited.remove(ele);
        // buffer.put(lis,ans);
        return dp[ind][mask]=ans;
        
    }
    public int specialPerm(int[] nums) {
        n=nums.length;
        // map=new HashMap<>();
        // for(int i=0;i<n-1;i++)
        // {
        //     map.putIfAbsent(nums[i],new ArrayList<>());
        //     for(int j=i+1;j<n;j++)
        //     {
        //         map.putIfAbsent(nums[j],new ArrayList<>());
        //         if(nums[i]%nums[j]==0 || nums[j]%nums[i]==0)
        //         {
        //             map.get(nums[i]).add(nums[j]);
        //             map.get(nums[j]).add(nums[i]);
        //         }
        //     }
        // }
        // System.out.println(map);
        // index=new HashMap<>();
        // for(int i=0;i<n;i++)
        //     index.put(nums[i],i);
        int count=0;
        // buffer=new HashMap<>();
        dp=new int[n][1<<n];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        for(int i=0;i<n;i++)
        {
            count+=helper(nums,i,(1<<i));
            count=count%mod;
        }   
        return count;
    }
}