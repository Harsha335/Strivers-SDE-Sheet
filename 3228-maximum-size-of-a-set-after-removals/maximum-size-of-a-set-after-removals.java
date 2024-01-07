class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // System.out.println(Arrays.toString(nums1));
        // System.out.println(Arrays.toString(nums2));
        // System.out.println();
        int common = 0;
        int count1 = 0;
        int count2 = 0;
        int i = 0, j = 0;
        int n = nums1.length;
        while(i<n && j<n)
        {
            if(nums1[i]<nums2[j])
            {
                i++;
                count1 ++;
            }
            if(j<n && i<n &&  nums2[j] < nums1[i])
            {
                j++;
                count2++;
            }
            if(i<n && j<n && nums1[i] == nums2[j])
            {
                i++;
                j++;
                common++;
            }
            while(i<n && i!=0 && nums1[i]==nums1[i-1])
                i++;
            // System.out.println(j);
            while(j<n && j!=0 && nums2[j]==nums2[j-1])
                j++;
            // System.out.println(i+" "+j);
        }
        while(i<n)
        {
            count1++;
            i++;
            while(i<n && nums1[i]==nums1[i-1])
                i++;
        }
        while(j<n)
        {
            count2++;
            j++;
            while(j<n && nums2[j]==nums2[j-1])
                j++;
        }
        // System.out.println(count1 +" "+count2+" "+common);
        return Math.min(n, Math.min(n/2,count1)+common+Math.min(n/2,count2));
    }
}