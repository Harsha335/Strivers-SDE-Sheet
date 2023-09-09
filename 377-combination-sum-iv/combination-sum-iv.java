class Solution {
    //TRYING TO USE PERMUTAION AND COMBINATION CONCEPT
    // int[] map;
    // double factorial(int num)
    // {
    //     if(num==1)return 1;
    //     return num*factorial(num-1);
    // }
    // double helper(int[] nums,int target,int ind)
    // {
    //     System.out.println(target+" "+ind);
    //     if(ind==-1)return 0;
    //     if(target<0) return 0;
    //     if(target==0)
    //     {
    //         int n=nums.length;
    //         int count=0;
    //         double denomi=1;
    //         double numa;
    //         for(int i=0;i<n;i++)
    //         {
    //             if(map[i]!=0)
    //             {
    //                 System.out.print(i+"-"+map[i]+" ");
    //                 count+=map[i];
    //                 denomi*=factorial(map[i]);
    //             }
    //         }
    //         System.out.println(count);
    //         numa=factorial(count);
    //         System.out.println(numa+"---"+denomi);
    //         return (long)(numa/denomi);
    //     }
    //     double ans=0;
    //     map[ind]++;
    //     ans+=helper(nums,target-nums[ind],ind);
    //     map[ind]--;
    //     ans+=helper(nums,target,ind-1);
    //     return ans;
    // }
    HashMap<Integer,Integer> map;
    int helper(int[] nums,int target)
    {
        if(target==0) return 1;
        if(target<0) return 0;
        if(map.containsKey(target))return map.get(target);
        int ans=0;
        for(int ele:nums)
        {
            ans+=helper(nums,target-ele);
        }
        map.put(target,ans);
        return ans;
    }
    public int combinationSum4(int[] nums, int target) {
        // map=new int[nums.length];
        // return (int)helper(nums,target,nums.length-1);
        map=new HashMap<>();
        return helper(nums,target);
    }
}