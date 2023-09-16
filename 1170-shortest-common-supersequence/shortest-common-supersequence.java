class Solution {
    int n,m;
    // String dp[][];
    // String helper(String s1,int i,String s2,int j)
    // {
    //     if(i==n){
    //         return s2.substring(j);
    //     }
    //     if(j==m){
    //         return s1.substring(i);
    //     }
    //     if(dp[i][j]!=null){
    //         return dp[i][j];
    //     }
    //     if(s1.charAt(i)==s2.charAt(j)){
    //         dp[i][j]=s1.charAt(i)+helper(s1,i+1,s2,j+1);
    //         return dp[i][j];
    //     }
    //     else{
    //         String ss1=s1.charAt(i)+helper(s1,i+1,s2,j);
    //         String ss2=s2.charAt(j)+helper(s1,i,s2,j+1);

    //         dp[i][j]=ss1.length()>ss2.length()?ss2:ss1;
    //         return dp[i][j];
    //     }
    // }
    String dp[][];
    String helper(String s1,int i,String s2,int j)
    {
        // List<Integer> ans=new ArrayList<>();
        String ans="";
        if(i==n || j==m)
        {
            return ans;
        }
        // System.out.println(dp[i][j]);
        if(dp[i][j]!=null)return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        {
            // System.out.println(i);
            // List<Integer> x=new ArrayList<>();
            // x.add(i);
            // x.addAll(helper(s1,i+1,s2,j+1));
            return s1.charAt(i)+helper(s1,i+1,s2,j+1);
        }
        // List<Integer> x1=helper(s1,i,s2,j+1);
        // List<Integer> x2=helper(s1,i+1,s2,j);
        // return dp[i][j]=(x1.size()>x2.size())?x1:x2;
        String x1=helper(s1,i,s2,j+1);
        String x2=helper(s1,i+1,s2,j);
        return dp[i][j]=(x1.length()>x2.length())?x1:x2;
        // x.add(i);
        // return x;
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        n=str1.length();
        m=str2.length();
        // dp=new String[n][m];
        // return helper(str1,0,str2,0);
        // dp=new List[n][m];
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<m;j++)
        //     {
        //         dp[i][j]=new ArrayList<>();
        //     }
        // }
        dp=new String[n][m];
        // for(int x[]:dp)
        // {
        //     Arrays.fill(x,new ArrayList<>());
        // }
        // List<Integer> subseq=helper(str1,0,str2,0);
        String subseq=helper(str1,0,str2,0);
        // System.out.println(subseq);
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        for(char x:subseq.toCharArray())
        {
            int index1=str1.indexOf(x,i);
            int index2=str2.indexOf(x,j);
            sb.append(str1.substring(i,index1));
            sb.append(str2.substring(j,index2+1));//add index too
            i=index1+1;
            j=index2+1;
        }
        if(i!=n)
        {
            sb.append(str1.substring(i));
        }
        if(j!=m)
        {
            sb.append(str2.substring(j));
        }
        return sb.toString();
    }
}