class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int curr[]=new int[m];
        int output=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]=='0')
                    curr[j]=0;
                else
                    curr[j]=curr[j]+1;
                // System.out.print(curr[j]+" ");
            }
            // System.out.println();
            Stack<Integer> st=new Stack<>();
            st.push(-1);
            // st.push(0);
            // int k=0;
            for(int k=0;k<m;k++)
            {
                if(st.peek()==-1 || curr[st.peek()]<curr[k])
                {
                    st.push(k);
                }
                else{
                    while(st.peek()!=-1 && curr[st.peek()]>=curr[k])
                    {
                        int last=st.pop();
                        output=Math.max(output,(k-(st.peek()+1))*curr[last]);
                    }
                    st.push(k);
                }
            // System.out.println(st);
            }
            int last=m;
            while(st.peek()!=-1)
            {
                int now=st.pop();
                output=Math.max(output,(m-(st.peek()+1))*curr[now]);
            }
            // System.out.println(output);
        }
        return output;
    }
}