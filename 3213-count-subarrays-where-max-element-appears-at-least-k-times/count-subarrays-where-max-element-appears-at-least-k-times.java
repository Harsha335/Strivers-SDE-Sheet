class Solution {
    // private int[] nextGreater(int nums[],int n)
    // {
    //     int arr[]=new int[n];
    //     Stack<Integer> st=new Stack<>();
    //     for(int i=0;i<n;i++)
    //     {
    //         while(!st.isEmpty() && nums[st.peek()]<=nums[i])
    //         {
    //             arr[st.pop()]=i;
    //         }
    //         st.push(i);
    //     }
    //     while(!st.isEmpty())
    //     {
    //         arr[st.pop()]=n;
    //     }
    //     return arr;
    // }
    // private int[] prevGreater(int nums[],int n)
    // {
    //     int arr[]=new int[n];
    //     Stack<Integer> st=new Stack<>();
    //     for(int i=n-1;i>=0;i--)
    //     {
    //         while(!st.isEmpty() && nums[st.peek()]<nums[i])
    //         {
    //             arr[st.pop()]=i;
    //         }
    //         st.push(i);
    //     }
    //     while(!st.isEmpty())
    //     {
    //         arr[st.pop()]=-1;
    //     }
    //     return arr;
    // }
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        // int nexty[]=nextGreater(nums,n);
        // int prev[]=prevGreater(nums,n);
        // for(int i=0;i<n;i++)
        // {
        //     System.out.println(i+" "+prev[i]);
        // }
        int i=0;
        int j=0;
        int maxi=0;
        for(int x:nums)
            maxi=Math.max(maxi,x);
        long output=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(j<n)
        {
            // map.putIfAbsent(nums[j],0);
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            // maxi=Math.max(nums[j],maxi);
            // System.out.println(i+" "+j+" "+maxi);
            while(map.getOrDefault(maxi,0)>=k)
            {
                
                // output+=(nexty[j]-j-1)*(i);
                // output+=i;
                // while(i<=j && nums[i]!=nums[j])
                // {
                    map.put(nums[i],map.get(nums[i])-1);
                    i++;
                    // output+=(nums[j]-j)*(i+1);
                    // output+=i;
                }
                // map.put(numys[i],map.get(nums[i])-1);
                
                // i++;
                output+=i;
                // System.out.println(i+"-"+j+" "+((nexty[j]-j)+" "+(i-prev[j]-1)));
                
            // }
            j+=1;
        }
        return output;
    }
}