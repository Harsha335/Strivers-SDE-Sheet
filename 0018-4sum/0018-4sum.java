class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        // for(int x:nums)System.out.print(x+" ");
        // System.out.println();
        int n=nums.length;
        List<List<Integer>> output=new ArrayList<>();
        for(int i=0;i<n-3;i++)
        {            
            while(i!=0 && i<n && nums[i-1]==nums[i])i++;
            for(int j=i+1;j<n-2;j++)
            {
                if(j!=i+1 && nums[j-1]==nums[j])continue;
                int ptr1=j+1;
                int ptr2=n-1;
                long tar=target-(long)(nums[i]+nums[j]);
                // System.out.println(i+" "+j+" "+tar);
                while(ptr1<ptr2)
                {
                    if((long)(nums[ptr1]+nums[ptr2])==tar)
                    {
                        output.add(Arrays.asList(nums[i],nums[j],nums[ptr1],nums[ptr2]));
                        int p1=nums[ptr1];
                        while(ptr1<ptr2 && nums[ptr1]==p1)ptr1++;
                        int p2=nums[ptr2];
                        while(ptr1<ptr2 && nums[ptr2]==p2)ptr2--;
                    }
                    else if((long)(nums[ptr1]+nums[ptr2])<tar)
                        ptr1++;
                    else
                        ptr2--;
                }
                // int p=nums[j];
                // System.out.println(j);

                // System.out.println(j);
            }
                // System.out.println(i);
            // while(i>0 && i<n && nums[i-1]==nums[i])i++;
                // System.out.println(i);
        }
        return output;
    }
}