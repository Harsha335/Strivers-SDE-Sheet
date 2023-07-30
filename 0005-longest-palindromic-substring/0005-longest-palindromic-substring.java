class Solution {
    int n;
    int[] check(int i,int j,String s)
    {
        while(i>=0 && j<n && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        // System.out.println(i+" "+j);
        return new int[]{i+1,j-1};
    }
    public String longestPalindrome(String s) {
        //check editorail
        n=s.length();
        int maxiLen=0;
        int finalI=0,finalJ=0;
        int cur[]=new int[]{0,0};
        for(int i=0;i<n-1;i++)
        {
            cur=check(i,i,s);
            if(cur[1]-cur[0]+1>maxiLen)
            {
                finalI=cur[0];
                finalJ=cur[1];
                maxiLen=cur[1]-cur[0]+1;
            }
            cur=check(i,i+1,s);
            if(cur[1]-cur[0]+1>maxiLen)
            {
                finalI=cur[0];
                finalJ=cur[1];
                maxiLen=cur[1]-cur[0]+1;
            }
            // System.out.println(maxiLen);
        }
        // cur=check(n-1,n-1,s);
        // if(cur[1]-cur[0]>maxiLen)
        // {
        //     finalI=cur[0];
        //     finalJ=cur[1];
        //     maxiLen=cur[1]-cur[0];
        // }
        return s.substring(finalI,finalJ+1);
    }
}