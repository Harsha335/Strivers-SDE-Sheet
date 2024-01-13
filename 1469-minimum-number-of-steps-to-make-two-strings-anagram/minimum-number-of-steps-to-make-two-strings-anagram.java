class Solution {
    public int minSteps(String s, String t) {
        int freq[] = new int[26];
        int n = s.length();
        for(int i = 0; i<n; i++){
            freq[s.charAt(i)-'a'] ++;
            freq[t.charAt(i)-'a'] --;
        }
        int count = 0;
        for(int i = 0; i<26; i++){
            count += Math.abs(freq[i]);
        }
        return count/2;
    }
}