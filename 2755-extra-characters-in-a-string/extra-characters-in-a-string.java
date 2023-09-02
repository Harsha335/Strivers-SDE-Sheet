class Solution {
    class Trie{
        Trie chars[];
        boolean isEnd;
        Trie(){
            chars=new Trie[26];
            isEnd=false;
        }
    }
    int n;
    int[] dp;
    int helper(String s,int i,Trie root)
    {
        if(i==n)
        {
            return 0;
        }
        if(dp[i]!=-1)
            return dp[i];
        Trie node=root;
        int ans=(int)1e9;
        for(int k=i;k<n;k++)
        {
            if(node.chars[s.charAt(k)-'a']==null)
            {
                break;
            }
            node=node.chars[s.charAt(k)-'a'];
            if(node.isEnd)
            {
                ans=Math.min(ans,helper(s,k+1,root));
            }
        }
        ans=Math.min(ans,1+helper(s,i+1,root));
        return dp[i]=ans;
    }
    public int minExtraChar(String s, String[] dictionary) {
        Trie root=new Trie();
        n=s.length();
        for(String x:dictionary)
        {
            Trie temp=root;
            for(char c:x.toCharArray())
            {
                if(temp.chars[c-'a']==null){
                    Trie node=new Trie();
                    temp.chars[c-'a']=node;
                }
                temp=temp.chars[c-'a'];
            }
            temp.isEnd=true;
        }
        dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(s,0,root);
    }
}