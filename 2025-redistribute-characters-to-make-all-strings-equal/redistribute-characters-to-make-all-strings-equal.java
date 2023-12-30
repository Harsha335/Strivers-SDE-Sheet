class Solution {
    public boolean makeEqual(String[] words) {
        int freq[] = new int[26];
        for(String x:words)
        {
            for(char c:x.toCharArray())
            {
                freq[c-'a']++;
            }
        }
        int n = words.length;
        for(int i=0;i<26;i++)
        {
            if(freq[i]%n!=0)
                return false;
        }
        return true;
    }
}