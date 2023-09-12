class Solution {
    public int minDeletions(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray())
        {
            freq[c-'a']++;
        }
        Arrays.sort(freq);
        int count=0;
        for(int i=24;i>=0;i--)
        {
            if(freq[i]==0)break;
            if(freq[i]>=freq[i+1])
            {
                count+=freq[i]-Math.max(0,freq[i+1]-1);
                freq[i]=freq[i+1]-1;
            }
        }
        return count;
    }
}