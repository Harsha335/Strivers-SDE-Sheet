class Solution {
    public int reductionOperations(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int level=0;
        int maxi=nums[0];
        int output=0;
        for(int i=1;i<n;i++)
        {
            if(nums[i]!=maxi){
                level++;
                maxi=nums[i];
            }
            output+=level;
        }
        return output;
    }
}