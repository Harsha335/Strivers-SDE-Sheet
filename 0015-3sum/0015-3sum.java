class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output=new ArrayList<>();
        int n=nums.length;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // for(int i=0;i<n;i++)
        // {
        //     map.put(nums[i],i);
        // }
        for(int i=0;i<n-2;i++)
        {
            // int target=-nums[i];
            // for(int j=i+1;j<n-1;j++)
            // {
            //     int ispresent=map.getOrDefault(target-nums[j],-1);
            //     if(ispresent>i)
            //     {
            //         List<Integer> curr=Arrays.asList(nums[i],nums[ispresent],nums[j]);
            //         Collections.sort(curr);
            //         // if(!output.contains(curr))
            //         output.add(curr);
            //         while(ptr1<n-1 && nums[ptr1]==nums[ptr1-1]) ptr1++;
            //     }
            // }
            while(i!=0 && i<n-2 && nums[i]==nums[i-1]) i++;
            int ptr1=i+1;
            int ptr2=n-1;
            int target=-nums[i];
            while(ptr1<ptr2)
            {
                if(nums[ptr1]+nums[ptr2]==target)
                {
                    List<Integer> curr=Arrays.asList(nums[i],nums[ptr1],nums[ptr2]);
                    // if(!output.contains(curr))
                    output.add(curr);
                    int lastptr1=nums[ptr1];
                    while(ptr1<ptr2 && nums[ptr1]==lastptr1) ptr1++;
                    int lastptr2=nums[ptr2];
                    while(ptr1<ptr2 && nums[ptr2]==lastptr2) ptr2--;
                    // break;
                }
                else if(nums[ptr1]+nums[ptr2]<target)
                {
                    ptr1++;
                }
                else ptr2--;
                // while(ptr1<n-1 && nums[ptr1]==nums[ptr1-1]) ptr1++;
                // while(ptr2>0 && nums[ptr2]==nums[ptr2-1]) ptr2--;
            }
        }    
        return output;    
    }
}