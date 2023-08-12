class Solution {
    public String convert(String s, int numRows) {
        StringBuilder output=new StringBuilder();
        int n=s.length();
        if(n==1 || numRows==1) return s;
        int jump=numRows-1+numRows-1;
        // System.out.println(n+" "+jump);
        for(int i=0;i<n;i+=jump)
        {
            // System.out.println(output+" "+i);
            output.append(s.charAt(i));
        }
        for(int k=1;k<numRows-1;k++)
        {
            jump-=2;
            for(int i=k;i<n;i+=2*k)
            {
                output.append(s.charAt(i));
                i+=jump;
                if(i>=n) break;
                output.append(s.charAt(i));
            }
        }
        jump=numRows-1+numRows-1;
        for(int i=numRows-1;i<n;i+=jump)
        {
            output.append(s.charAt(i));
        }
        return output.toString();
    }
}