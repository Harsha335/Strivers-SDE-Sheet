class Solution {
    public int strStr(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        int lps[]=new int[m];
        lps[0]=0;
        int ind=1;
        int len=0;
        while(ind<m)
        {
            if(needle.charAt(ind)==needle.charAt(len))
            {
                lps[ind]=len+1;
                len++;
                ind++;
            }
            else{
                if(len==0)
                {
                    lps[ind]=0;
                    ind++;
                }
                else{
                    len=lps[len-1];
                }
            }
        }
        // for(int i=0;i<m;i++)System.out.println(lps[i]);
        int i=0;
        int j=0;
        while(i<n)
        {
            if(haystack.charAt(i)==needle.charAt(j))
            {
                i++;
                j++;
            }
            else {
                if(j!=0)
                j=lps[j-1];
                else i+=1;
            }
            if(j==m)return i-m;
        }
        return -1;
    }
}