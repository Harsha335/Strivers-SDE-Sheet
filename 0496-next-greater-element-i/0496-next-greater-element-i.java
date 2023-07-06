class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        Stack<Integer> st=new Stack<>();
        //greatest in 2nd array
        HashMap<Integer,Integer> nextGreater=new HashMap<>();
        for(int x:nums2)
        {
            if(st.isEmpty() || st.peek()>=x)
            {
                st.push(x);
            }
            else{
                while(!st.isEmpty() && st.peek()<x)
                {
                    nextGreater.put(st.pop(),x);
                }
                st.push(x);
            }
        }
        while(!st.isEmpty())
        {
            nextGreater.put(st.pop(),-1);
        }
        int n=nums1.length;
        int output[]=new int[n];
        for(int i=0;i<n;i++)
        {
            output[i]=nextGreater.get(nums1[i]);
        }
        return output;
    }
}