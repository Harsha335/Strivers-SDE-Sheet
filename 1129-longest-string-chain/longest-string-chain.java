class Solution {
    boolean isPredecessor(String s1,String s2,int n1,int n2)
    {
        // System.out.println(s1+" "+s2);
        int i=0,j;
        for(j=0;j<n2;j++)
        {
            if(i==n1)return true;
        // System.out.println(s1.charAt(i)+" "+s2.charAt(j));
            if(s1.charAt(i)!=s2.charAt(j))
            {
                if(i!=j)return false;
            }
            else
                i++;
        }
        return true;
    }
    int dp[];
    int helper(HashMap<Integer,List<Integer>> map,int start)
    {
        if(dp[start]!=-1)return dp[start];
        if(!map.containsKey(start))return 0;
        int maxi=0;
        for(int x:map.get(start))
        {
            maxi=Math.max(maxi,1+helper(map,x));
        }
        return dp[start]=maxi;
    }
    public int longestStrChain(String[] words) {
        int n=words.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();//index of string-all predecessor strings
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int lengths[]=new int[n];
        int ind=0;
        for(String x:words)
        {
            lengths[ind++]=x.length();
        }
            // System.out.println();
        for(int i=0;i<n;i++)
        {
            map.put(i,new ArrayList<>());
            int n1=lengths[i];
            for(int j=i+1;j<n;j++)
            {
                int n2=lengths[j];
                if(!(n1==n2 || (n1+1)==n2))
                    break;
                // System.out.println(i+" "+j);
                if((n1+1)==n2 && isPredecessor(words[i],words[j],n1,n2))
                {
                // System.out.println(i+"-"+j);
                    map.get(i).add(j);
                }
            }
        }
        // System.out.println(map);
        dp=new int[n];
        Arrays.fill(dp,-1);
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            maxi=Math.max(maxi,1+helper(map,i));
        }
        return maxi;
    }
}