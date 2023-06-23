class Solution {
    List<List<Integer>> output;
    void helper(int nums[],int ind,int n,List<Integer> temp)
    {
        output.add(new ArrayList<>(temp));
        for(int i=ind;i<n;i++)
        {
            if(i!=ind && nums[i]==nums[i-1])continue;
            temp.add(nums[i]);
            helper(nums,i+1,n,temp);
            temp.remove(Integer.valueOf(nums[i]));
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        output=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(nums,0,nums.length,temp);
        return output;
    }
}