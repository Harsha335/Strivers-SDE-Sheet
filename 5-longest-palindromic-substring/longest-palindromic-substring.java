class Solution {
    int n;
    int[] check(int i,int j,String s)
    {
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return new int[]{i+1,j-1};
    }
    public String longestPalindrome(String s) {
        //check editorail
        n=s.length();
        // int maxiLen=0;
        int finalI=0,finalJ=0;
        
        for(int i=0;i<n-1;i++)
        {
            int cur[]=check(i,i,s);
            if((cur[1]-cur[0])>(finalJ-finalI))
            {
                finalI=cur[0];
                finalJ=cur[1];
            }
            cur=check(i,i+1,s);
            if((cur[1]-cur[0])>(finalJ-finalI))
            {
                finalI=cur[0];
                finalJ=cur[1];
            }
        }
        return s.substring(finalI,finalJ+1);
    }
}