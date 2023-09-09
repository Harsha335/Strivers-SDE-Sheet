class Solution {
    public int mySqrt(int x) {
        int low=0;
        int high=x;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            // System.out.println(low+" "+high+" "+mid);
            if(((double)mid*mid)<=((double)x))
            {
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
}