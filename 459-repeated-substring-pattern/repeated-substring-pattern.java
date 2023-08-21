class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        if(n<=1) return false;
        int lps=createLps(s);
        if(lps<n && n%lps==0) return true;
        return false;
    }
    int createLps(String s)
    {
        int n=s.length();
        int len=0;
        int i=1;
        int lps[]=new int[n];
        lps[0]=0;
        while(i<n)
        {
            // System.out.println(i+" "+len);
            if(s.charAt(i)==s.charAt(len))
            {
                lps[i]=len+1;
                len+=1;
                i++;
            }
            else{
                if(len==0) i++;
                else{
                    len=lps[len-1];
                }
            }
        }
        // for(i=0;i<n;i++)
        // {
        //     System.out.print(lps[i]+" ");
        // }
        return n-lps[n-1];
    }
}