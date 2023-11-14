class Solution {
    public long maxBalancedSubsequenceSum(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=nums[i]-i;
        }
        TreeMap<Integer,Long> map=new TreeMap<>();
        long ans=-(int)1e9;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<=0)
            {
                ans=Math.max(ans,nums[i]);
            }
            else{
                long temp=nums[i];
                if(map.floorKey(arr[i])!=null)
                {
                    temp+=map.get(map.floorKey(arr[i]));
                }
                // else{
                //     map.put(arr[i],temp);
                // }
                while(map.higherKey(arr[i])!=null && map.get(map.higherKey(arr[i]))<temp)
                    map.remove(map.higherKey(arr[i]));
                if(map.floorKey(arr[i])==null || map.floorKey(arr[i])<temp)
                {
                    map.put(arr[i],temp);
                }
                ans=Math.max(ans,temp);
            }
        }
        return ans;
    }
}