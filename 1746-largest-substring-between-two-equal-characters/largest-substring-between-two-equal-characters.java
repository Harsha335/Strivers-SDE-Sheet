class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int output = -1;
        int freq[] = new int[26];//last index of character
        Arrays.fill(freq,-1);
        int n=s.length();
        for(int i= 0;i<n;i++)
        {
            if(freq[s.charAt(i)-'a']==-1)
                freq[s.charAt(i)-'a']=i;
            else
            {
                output=Math.max(output,i-freq[s.charAt(i)-'a']-1);
            }
        }
        return output;
    }
}