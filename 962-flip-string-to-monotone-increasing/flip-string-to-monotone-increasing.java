class Solution {
    // int dp[][];
    // int helper(String s,int ind,int n,boolean isOnes){
    //     if(ind==n) return 0;
    //     if(dp[ind][isOnes?1:0]!=-1) return dp[ind][isOnes?1:0];
    //     int ans=0;
    //     // System.out.println(ind+" "+isOnes);
    //     if(!isOnes)
    //     {
    //         if(s.charAt(ind)=='0')
    //         {
    //             ans+=helper(s,ind+1,n,isOnes);
    //         }
    //         else{
    //             ans+=Math.min(1+helper(s,ind+1,n,isOnes),helper(s,ind+1,n,true));
    //         }
    //     }
    //     else{
    //         if(s.charAt(ind)=='1')
    //         {
    //             ans+=helper(s,ind+1,n,isOnes);
    //         }
    //         else{
    //             ans+=1+helper(s,ind+1,n,isOnes);
    //         }
    //     }
    //     return dp[ind][isOnes?1:0]=ans;
    // }
    public int minFlipsMonoIncr(String s) {
        // dp=new int[s.length()][2];
        // for(int[] x:dp)
        // {
        //     Arrays.fill(x,-1);
        // }
        // return helper(s,0,s.length(),false);
        int[] left=new int[2];
        int[] right=new int[2];
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            right[s.charAt(i)-'0']++;
        }
        int ans=Math.min(right[0],right[1]);
        for(int i=0;i<n;i++)
        {
            left[s.charAt(i)-'0']++;
            right[s.charAt(i)-'0']--;
            ans=Math.min(ans,left[1]+right[0]);
        }
        return ans;
    }
}