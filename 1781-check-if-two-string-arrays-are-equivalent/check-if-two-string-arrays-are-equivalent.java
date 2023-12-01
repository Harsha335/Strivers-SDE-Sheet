class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0;
        int indI=0;
        int j=0;
        int indJ=0;
        int x=word1[0].length();
        int n=word1.length;
        int y=word2[0].length();
        int m=word2.length;
        while(i<n && j<m)
        {
            if(word1[i].charAt(indI)!=word2[j].charAt(indJ))
                return false;
            indI++;
            indJ++;
            if(indI==x)
            {
                indI=0;
                i++;
                if(i!=n)
                    x=word1[i].length();
            }
            if(indJ==y)
            {
                indJ=0;
                j++;
                if(j!=m)
                    y=word2[j].length();
            }
        }
        return i==n && j==m;
    }
}