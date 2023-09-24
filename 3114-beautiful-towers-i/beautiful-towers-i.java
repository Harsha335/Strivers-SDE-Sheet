class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long maxsum=0;
        int n=maxHeights.size();
        for(int index=0;index<n;index++)
        {
            // System.out.println(index);
            // List<Integer> maxHeight=new ArrayList(maxHeights);
            long sum=maxHeights.get(index);
            int curMaxi=maxHeights.get(index);
            for(int i=index-1;i>=0;i--)
            {
                // maxHeight.set(i,Math.min(maxHeight.get(i),maxHeight.get(i+1)));
                curMaxi=Math.min(curMaxi,maxHeights.get(i));
                sum+=curMaxi;
            }
            curMaxi=maxHeights.get(index);
            for(int i=index+1;i<n;i++)
            {
                
                // maxHeight.set(i,Math.min(maxHeight.get(i),maxHeight.get(i-1)));
                curMaxi=Math.min(curMaxi,maxHeights.get(i));
                sum+=curMaxi;
            }
            maxsum=Math.max(maxsum,sum);
            // System.out.println(maxsum);
        }
        
        return maxsum;
    }
}