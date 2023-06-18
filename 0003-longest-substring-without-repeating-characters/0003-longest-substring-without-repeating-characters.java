class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> index=new HashMap<>();
        int n=s.length();
        int start=0,maxcount=0;
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            int ind=index.getOrDefault(c,-1);
            if(ind>=start)
            {
                maxcount=Math.max(maxcount,i-start);
                start=ind+1;
            }
            index.put(c,i);
        }
        return Math.max(maxcount,n-start);
    }
}