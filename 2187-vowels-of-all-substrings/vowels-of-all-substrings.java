class Solution {
    public long countVowels(String word) {
        long count=0;
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            if("aeiou".indexOf(word.charAt(i))!=-1)
            {
                count+=(long)(n-i)*(i+1);
            }
        }
        return count;
    }
}