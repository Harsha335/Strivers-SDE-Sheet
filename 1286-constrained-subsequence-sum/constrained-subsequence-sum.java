class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        // int pre=0;
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->b.get(0)-a.get(0));
        int j=0;
        int n=nums.length;
        int dp[]=new int[n];
        int maxi=-(int)1e9;
        for(int i=0;i<n;i++)
        {
            if((i)>=k)
            {
                // System.out.println(pq);
                while(!pq.isEmpty() && pq.peek().get(1)<(i-k))
                {
                    // System.out.println(i);
                    pq.poll();
                }
                // System.out.println(pq);
                int pre=0;
                if(!pq.isEmpty())
                {
                    pre=pq.peek().get(0);
                }
                dp[i]=Math.max(nums[i],pre+nums[i]);
            }
            else{
                int pre=0;
                if(!pq.isEmpty())
                {
                    pre=pq.peek().get(0);
                }
                dp[i]=Math.max(nums[i],pre+nums[i]);
            }
            // System.out.println(dp[i]);
            pq.add(Arrays.asList(dp[i],i));
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}