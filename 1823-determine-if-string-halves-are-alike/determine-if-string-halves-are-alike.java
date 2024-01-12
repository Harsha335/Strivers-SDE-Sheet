class Solution {
    public boolean halvesAreAlike(String s) {
        // HashMap<Character, Integer> freq = new HashMap<>();
        int freqVowels = 0;
        int n = s.length();
        String vowels = "aeiouAEIOU";
        for(int i = 0; i<n; i++){
            if(vowels.indexOf(s.charAt(i)) == -1)
                continue;
            // freq.putIfAbsent(s.charAt(i), 0);
            if(i<n/2){
                // freq.put(s.charAt(i), freq.get(s.charAt(i))+1);
                freqVowels ++;
            }else{
                // freq.put(s.charAt(i), freq.get(s.charAt(i))-1);
                freqVowels --;
            }
        }
        // for(char c: freq.keySet()){
        //     if(freq.get(c) != 0)
        //         return false;
        // }
        return freqVowels == 0;
    }
}