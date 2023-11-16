class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int last=(int)Math.pow(2,n);
        int ind=0;
        for(int i=0;i<last;i++)
        {
            String cur=String.format("%"+n+"s",Integer.toBinaryString(i)).replace(" ","0");
            if(ind==n)
                return cur;
            if(!nums[ind++].equals(cur))
            {
                return cur;
            }
        }
        return "-1";
    }
}