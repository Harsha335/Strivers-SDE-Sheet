class Solution {
    // int dp[][];
    // int helper(List<List<Integer>> offers,int curr,int m,int last)
    // {
    //     if(curr==m)return 0;
    //     if(dp[curr][last+1]!=-1) return dp[curr][last+1];
    //     int take=0,nottake=0;
    //     if(offers.get(curr).get(0)>last)
    //     {
    //         take=offers.get(curr).get(2)+helper(offers,curr+1,m,offers.get(curr).get(1));
    //     }
    //     nottake=helper(offers,curr+1,m,last);
    //     return dp[curr][last+1]=Math.max(take,nottake);
    // }
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers,(a,b)->{
            return a.get(1)-b.get(1);
        });
        // dp=new int[offers.size()][n+1];
        // for(int x[]:dp)
        // {
        //     Arrays.fill(x,-1);
        // }
        // return helper(offers,0,offers.size(),-1);
        int dp[]=new int[n];
        List<List<Integer>> last[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            last[i]=new ArrayList<>();
        }
        for(List<Integer> x:offers)
        {
            last[x.get(1)].add(x);
        }
        // for(int i=0;i<n;i++)
        //     System.out.println(i+" "+last[i]);
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            for(List<Integer> x:last[i])
            {
                if((x.get(0)-1)>=0)
                {
                    dp[i]=Math.max(dp[i],x.get(2)+dp[x.get(0)-1]);
                }
                else{
                    dp[i]=Math.max(dp[i],x.get(2));
                }
                maxi=Math.max(maxi,dp[i]);
            }
            if(i!=0)
                dp[i]=Math.max(dp[i],dp[i-1]);
            // System.out.println(i+" "+dp[i]);
        }
        return maxi; 
        // Collections.sort(offers,(a,b)->{
        //     return ((b.get(1)-b.get(0)+1)*b.get(2))-((a.get(1)-a.get(0)+1)*a.get(2));
        // });
        // HashSet<Integer> set=new HashSet<>();
        // boolean visit[]=new boolean[n];
        // int profit=0;
        // int m=offers.size();
        // System.out.println(offers);
        // for(int i=0;i<m;i++)
        // {
        //     List<Integer> x=offers.get(i);
        //     int start=x.get(0);
        //     int end=x.get(1);
        //     int price=x.get(2);
        //     boolean cant=false;
        //     for(int j=start;j<=end;j++)
        //     {
        //         if(visit[j])
        //             cant=true; 
        //     }
        //     if(cant)continue;
        //     for(int j=start;j<=end;j++)
        //     {
        //         visit[j]=true;
        //     }
        //     profit+=price;
        // }
        // return profit;
    }
}