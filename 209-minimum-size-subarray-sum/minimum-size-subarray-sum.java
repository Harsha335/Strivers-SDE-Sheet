class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //  2-POINTERS

        // int start=0;
        // // int end=0;
        // int sum=0;
        // int minLen=(int)1e9;
        // int n=nums.length;
        // for(int i=0;i<n;i++)
        // {
        //     sum+=nums[i];
        //     if(sum>=target)
        //     {
        //         while(start<n && (sum-nums[start])>=target)
        //         {
        //             // System.out.println(start+" "+sum);
        //             sum-=nums[start];
        //             start++;
        //         }
        //         minLen=Math.min(minLen,i-start+1);
        //     }
        // }
        // return (minLen==(int)1e9)?0:minLen;

        //BINARY SERACH

        int n=nums.length;
        int prefix[]=new int[n];    //bs on prefix
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
            // System.out.println(prefix[i]);
        }
        int output=(int)1e9;
        for(int i=0;i<n;i++)
        {
            output=Math.min(output,helper(prefix,i==0?0:prefix[i-1],i,n,target));
            // System.out.println("out "+output);
        }
        return output==(int)1e9?0:output;
    }
    int helper(int[] prefix,int subtract,int ind,int n,int target)
    {
        int i=ind;
        int j=n-1;
        int ans=(int)1e9;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            // System.out.println(prefix[mid]);
            if((prefix[mid]-subtract)>=target)
            {
                ans=mid;
                j=mid-1;
            }
            else
            {
                i=mid+1;
            }
        }
        // System.out.println(subtract+" "+ans+"-");
        return ans==(int)1e9?ans:ans-ind+1;
    }
}