class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();
        int prefix[]=new int[n];
        int toLeft[]=new int[n];
        int toRight[]=new int[n];
        if(s.charAt(0)=='*')
            prefix[0]=1;
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1];
            if(s.charAt(i)=='*')
                prefix[i]++;
        }
        toLeft[0]=-1;
        if(s.charAt(0)=='|')
            toLeft[0]=0;
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)=='|')
                toLeft[i]=i;
            else
                toLeft[i]=toLeft[i-1];
        }
        toRight[n-1]=n;
        if(s.charAt(n-1)=='|')
            toRight[n-1]=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(s.charAt(i)=='|')
                toRight[i]=i;
            else
                toRight[i]=toRight[i+1];
        }
        int q=queries.length;
        int output[]=new int[q];
        for(int i=0;i<q;i++)
        {
            int left=toRight[queries[i][0]];
            int right=toLeft[queries[i][1]];
            // System.out.println(i+" "+left+" "+right);
            if(right>=queries[i][0] && left<=queries[i][1])
                output[i]=prefix[right]-prefix[left];
        }
        return output;
    }
}