class Solution {
    public int countCharacters(String[] words, String chars) {
        int freq[]=new int[26];
        for(char c:chars.toCharArray())
        {
            freq[c-'a']++;
        }
        int output=0;
        for(String s:words)
        {
            int currFreq[]=new int[26];
            boolean isPossible=true;
            for(char c:s.toCharArray())
            {
                currFreq[c-'a']++;
                if(currFreq[c-'a']>freq[c-'a'])
                {
                    isPossible=false;
                    break;
                }
            }
            if(isPossible)
            {
                // System.out.println(s);
                output+=s.length();
            }
        }
        return output;
    }
}