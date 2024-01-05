class Solution {
    private int binarySearch(List<Integer> sorted,int i,int j,int tar)
    {
        int ans = j;
        while(i<=j)
        {
            int mid = (i+j)>>1;
            if(sorted.get(mid) >= tar)
            {
                ans = mid;
                j = mid-1;
            }
            else
                i = mid+1;
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        int length = 0;
        for(int ele: nums)
        {
            if(length == 0 || sorted.get(length-1) < ele)
            {
                sorted.add(ele);
                length++;
            }
            else{
                int index = binarySearch(sorted,0,length-1,ele);    //replace greater than equal element
                sorted.set(index,ele);
            }
        }
        return length;
    }
}