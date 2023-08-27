class Solution {
    List<List<Integer>> output;
    void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void helper(int[] nums,int ind,int n)
    {
        if(ind==n){
            List<Integer> l=new ArrayList<>();
            // System.out.println(l);
            for(int x:nums) l.add(x);
            output.add(l);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=ind;i<n;i++)
        {
            if(!set.contains(nums[i]))
            {
                swap(nums,ind,i);
                helper(nums,ind+1,n);
                swap(nums,ind,i);
                set.add(nums[i]);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        output=new ArrayList<>();
        helper(nums,0,nums.length);
        return output;
    }
}