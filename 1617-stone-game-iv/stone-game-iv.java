class Solution {
    Boolean dp[];
    List<Integer> square;
    int len;
    boolean helper(int n)
    {
        if(n<=0)
        {
            // if(isAlice) return false;
            return false;
        }
        if(dp[n]!=null)
            return dp[n];
        // if(isAlice)
        // {
            // boolean res=false;
            for(int i=0;i<len;i++)
            {
                if(n<square.get(i))
                    break;
                if(!helper(n-square.get(i)))
                    return dp[n]=true;
            }
            return dp[n]=false;
        // }
        // boolean res=true;
        // for(int i=0;i<len;i++)
        // {
        //     if(n>square.get(i))
        //         break;
        //     if(!helper(true,n-square.get(i)))
        //         return true;
        // }
        // return false;
    }
    public boolean winnerSquareGame(int n) {
        dp=new Boolean[n+1];
        square=new ArrayList<>();
        len=0;
        // int root=Math.sqrt(n);
        for(int i=1;(i*i)<=n;i++)
        {
            // System.out.println(i);
            square.add(i*i);
            len++;
        }
        return helper(n);
    }
}