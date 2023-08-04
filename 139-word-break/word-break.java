class Solution {
    // int n;
    // int dp[][];
    // boolean helper(String s,int i,int j,List<String> wordDict){
    //     if(j==n-1){
    //         // System.out.println(s.substring(i,j+1));
    //         if(wordDict.contains(s.substring(i,j+1))){
    //             return true;
    //         }
    //         return false;
    //     }
    //     if(dp[i][j]!=-1)return dp[i][j]==1?true:false;
    //     if(wordDict.contains(s.substring(i,j+1))){
    //         dp[i][j]=helper(s,j+1,j+1,wordDict)?1:0;
    //         if(dp[i][j]==1)return true;
    //     }
    //     dp[i][j]=helper(s,i,j+1,wordDict)?1:0;
    //     return dp[i][j]==1?true:false;
    // }
    public boolean wordBreak(String s, List<String> wordDict) {
        // n=s.length();
        // dp=new int[n][n];
        // for(int x[]:dp){
        //     Arrays.fill(x,-1);
        // }
        // return helper(s,0,0,wordDict);

        int n=s.length();
        List<Integer> isTrues=new ArrayList<>();
        isTrues.add(0); //index+1 ("" is true)
        for(int i=0;i<n;i++)
        {
            for(int ind:isTrues)
            {
                if(wordDict.contains(s.substring(ind,i+1))){
                    isTrues.add(i+1);
                    break;
                }
            }
        }
        return isTrues.contains(n);
    }
}