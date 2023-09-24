class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        // int maxi=0;
        // int index=0;
        // int ind=0;
        // for(int x:maxHeight)
        // {
        //     if(maxi<x)
        //     {
        //         maxi=x;
        //         index=ind;
        //     }
        //     ind++;
        // }
        double maxsum=0;
        int n=maxHeights.size();
        // int pre=maxi;
        for(int index=0;index<n;index++)
        {
            // System.out.println(index);
            List<Integer> maxHeight=new ArrayList(maxHeights);
            double sum=0;
            for(int i=index-1;i>=0;i--)
            {
                maxHeight.set(i,Math.min(maxHeight.get(i),maxHeight.get(i+1)));
                sum+=maxHeight.get(i);
            }
            for(int i=index+1;i<n;i++)
            {
                
                maxHeight.set(i,Math.min(maxHeight.get(i),maxHeight.get(i-1)));
                sum+=maxHeight.get(i);
            }
            maxsum=Math.max(maxsum,sum+(double)maxHeight.get(index));
            // System.out.println(maxsum);
        }
        
        return (long)maxsum;
    }
}