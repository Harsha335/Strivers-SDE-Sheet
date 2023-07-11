class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int preSmallest[]=new int[n];
        int nextSmallest[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            if(st.isEmpty() || heights[st.peek()]<=heights[i])
            {
                st.push(i);
            }
            else{
                while(!st.isEmpty() && heights[st.peek()]>heights[i])
                {
                    preSmallest[st.pop()]=i;
                }
                st.push(i);
            }
        }
        while(!st.isEmpty())
        {
            preSmallest[st.pop()]=-1;
        }

        st.clear();
        for(int i=0;i<n;i++)
        {
            if(st.isEmpty() || heights[st.peek()]<=heights[i])
            {
                st.push(i);
            }
            else{
                while(!st.isEmpty() && heights[st.peek()]>heights[i])
                {
                    nextSmallest[st.pop()]=i;
                }
                st.push(i);
            }
        }
        while(!st.isEmpty())
        {
            nextSmallest[st.pop()]=n;
        }
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,heights[i]*(nextSmallest[i]-preSmallest[i]-1));
        }
        return maxi;
    }
}