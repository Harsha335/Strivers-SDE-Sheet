class Solution {
    boolean visited[];
    // HashMap<Character,Integer> counter[];
    int n;
    int len;
    // boolean isEqual(HashMap<Character,Integer> c1,HashMap<Character,Integer> c2)
    // {
    //     int count=0;
    //     for(char ch:c1.keySet())
    //     {
    //         if(!c2.containsKey(ch))
    //             count+=c1.get(ch);
    //         else
    //             count+=(c1.get(ch)-c2.get(ch));
    //     }
    //     return count==1;
    // }
    boolean isEqual(String s1,String s2)
    {
        int count=0;
        
        // System.out.println(s1+" "+s2);
        for(int i=0;i<len;i++)
        {
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
        }
        return count==1;
    }
    // int dp[];
    // int helper(String s,int ind,String end,List<String> wordList)
    // {
    //     if(s.equals(end))
    //         return 1;
    //     if(dp[ind]!=-1)
    //         return dp[ind];
    //     int ans=(int)1e9;
    //     for(int i=0;i<n;i++)
    //     {
    //         if(!visited[i] && isEqual(s,wordList.get(i)))
    //         {
    //             visited[i]=true;
    //             // System.out.println(wordList.get(i));
    //             ans=Math.min(ans,1+helper(wordList.get(i),i,end,wordList));
    //             // System.out.println("--");
    //             visited[i]=false;
    //         }
    //     }
    //     return dp[ind]=ans;
    // }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        n=wordList.size();
        visited=new boolean[n];
        len=beginWord.length();
        // dp=new int[n];
        // Arrays.fill(dp,-1);
        // counter=new HashMap[n];
        // for(int i=0;i<n;i++)
        // {
        //     counter[i]=new HashMap<>();
        // }
        // int ind=0;
        // for(String x:wordList)
        // {
        //     for(char ch:x.toCharArray())
        //     {
        //         counter[ind].put(ch,counter[ind].getOrDefault(ch,0)+1);
        //     }
        //     // System.out.println(counter[ind]);
        //     ind++;
        // }
        // HashMap<Character,Integer> beginCounter=new HashMap<>();
        // for(char ch:beginWord.toCharArray())
        // {
        //     beginCounter.put(ch,beginCounter.getOrDefault(ch,0)+1);
        // }
        // int ans=(int)1e9;
        Queue<String> q=new LinkedList<>();
        // for(int i=0;i<n;i++)
        // {
        //     String ss=wordList.get(i);
        //     if(isEqual(beginWord,ss))
        //     {

        //         visited[i]=true;
        //         // System.out.println(ss);
        //         ans=Math.min(ans,1+helper(ss,i,endWord,wordList));
        //         // System.out.println("-----------------");
        //         visited[i]=false;
        //     }
        // }
        // return (ans==(int)1e9)?0:ans;
        q.add(beginWord);
        int level=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-->0)
            {
                String ss=q.poll();
                for(int i=0;i<n;i++)
                {
                    if(!visited[i] && isEqual(wordList.get(i),ss))
                    {
                        if(wordList.get(i).equals(endWord))
                            return level+1;
                        q.add(wordList.get(i));
                        visited[i]=true;
                    }
                }

            }
            level++;
        }
        return 0;
    }
}