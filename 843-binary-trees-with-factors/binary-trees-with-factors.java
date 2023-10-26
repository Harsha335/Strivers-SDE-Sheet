class Solution {
    private int mod=(int)1e9+7;
    private long dp[];
    private long helper(List<Integer> map[],int curr,int arr[],HashMap<Integer,Integer> index)
    {
        if(dp[curr]!=-1)
            return dp[curr];
        if(map[curr].size()==0)
            return dp[curr]=1;
        long count=1;
        // System.out.println(curr+"-");
        for(int x:map[curr])
        {
            count=count+(helper(map,x,arr,index)*helper(map,index.get(arr[curr]/arr[x]),arr,index))%mod;
            count=(count)%mod;
        }
        return dp[curr]=count;
    }
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        HashMap<Integer,Integer> index=new HashMap<>();
        int ind=0;
        for(int x:arr)
        {
            index.put(x,ind++);
        }
        List<Integer> map[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            map[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++)
        {
            double root=Math.sqrt(arr[i]);
            for(int j=0;j<i;j++)
            {
                if(root<arr[j])
                    break;
                // System.out.println(arr[i]%arr[j]);
                if(arr[i]%arr[j]==0 && index.containsKey(arr[i]/arr[j]))
                {
                    map[i].add(j);
                    if(j!=index.get(arr[i]/arr[j]))
                        map[i].add(index.get(arr[i]/arr[j]));
                }
            }
            // System.out.println(i+" "+map[i]);
        }
        long count=0;
        dp=new long[n];
        Arrays.fill(dp,-1);
        for(int i=0;i<n;i++)
        {
            count=count+helper(map,i,arr,index);
            // System.out.println(count);
            count=(count)%mod;
        }
        return (int)count;
    }
}