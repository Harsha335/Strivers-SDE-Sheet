class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int[] count=new int[n];
        int[] count2=new int[n];
        // Arrays.fill(count,1);
        // Arrays.fill(count2,1);
        for(int i=1;i<n;i++)
        {
            if(ratings[i]>ratings[i-1]) count[i]=count[i-1]+1;
        }
        for(int i=n-2;i>=0;i--)
        {
            if(ratings[i]>ratings[i+1]) count2[i]=count2[i+1]+1;
        }
        int ans=0;
        for(int i=0;i<n;i++)
        {
            ans+=Math.max(count[i],count2[i])+1;   
        }
        return ans;
    }
}