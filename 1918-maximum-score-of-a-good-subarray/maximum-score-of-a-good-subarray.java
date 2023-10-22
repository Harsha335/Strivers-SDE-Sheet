class Solution {
    public int maximumScore(int[] nums, int k) {
        int n=nums.length;
        int left[]=new int[n];
        int right[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
            {
                right[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            right[st.pop()]=n;
        }
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
            {
                left[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty())
        {
            left[st.pop()]=-1;
        }

        int output=0;
        for(int i=0;i<n;i++)
        {
            // System.out.println(left[i]+" "+right[i]);
            if(k>left[i] && k<right[i])
            {
            // System.out.println();
                output=Math.max(output,nums[i]*(right[i]-left[i]-1));
            }
        }
        return output;
    }
}