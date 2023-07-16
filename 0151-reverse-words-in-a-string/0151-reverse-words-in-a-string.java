class Solution {
    public String reverseWords(String s) {
        Stack<String> st=new Stack<>();
        int i=0,j=i,n=s.length();
        while(j<n)
        {
            if(s.charAt(j)==' ')
            {
                if(i!=j)
                {
                    st.push(s.substring(i,j));
                    i=j;
                }
                i+=1;
                j=i;
            }
            else{
                j++;
            }
        }
        // System.out.println(st);
        if(i!=j)st.push(s.substring(i,j));
        String output=new String();
        while(!st.isEmpty()) output+=st.pop()+" ";
        return output.substring(0,output.length()-1);
    }
}