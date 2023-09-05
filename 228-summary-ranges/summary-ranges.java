class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        List<String> output=new ArrayList<>();
        int i=0;
        while(i<n)
        {
            int last=i;
            while(last+1<n && nums[last]+1==nums[last+1])
                last++;
            if(i==last)
                output.add(String.valueOf(nums[i]));
            else{
                output.add(String.valueOf(nums[i]+"->"+nums[last]));
            }
            i=last+1;
        }
        return output;
    }
}