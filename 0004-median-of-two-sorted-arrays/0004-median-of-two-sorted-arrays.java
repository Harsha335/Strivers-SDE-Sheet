class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length)
        {
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
        }
        int n=nums1.length;
        int m=nums2.length;
        int total=(n+m+1)/2;
        int i=0,j=n;
        while(i<=j)
        {
            int mid=(i+j)>>1;
            int left1=(mid==0)?-(int)1e9:nums1[mid-1];
            int right1=(mid==n)?(int)1e9:nums1[mid];
            int mid2=total-mid;
            // System.out.println(i+" "+j+" "+mid2);
            int left2=(mid2==0)?-(int)1e9:nums2[mid2-1];
            int right2=(mid2==m)?(int)1e9:nums2[mid2];
            if(left1<=right2 && left2<=right1)  //ans found
            {
                if((n+m)%2==0)
                {
                    return (double)(Math.max(left1,left2)+Math.min(right1,right2))/2;
                }
                return Math.max(left1,left2);
            }
            if(left1>=right2)
            {
                j=mid-1;
            }
            else i=mid+1;
        }
        return 0.0;
    }
}