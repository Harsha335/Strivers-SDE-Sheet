class Solution {
    public int maxScore(String s) {
        int zeroLeft = 0;
        int oneRight = 0;
        int n = s.length();
        for(int i = 0;i < n;i++)
        {
            if(s.charAt(i) == '1')
            {
                oneRight +=1;
            }
        }
        int output = 0;
        for(int i = 0;i<n-1;i++)
        {
            if(s.charAt(i) == '0')
            {
                zeroLeft+=1;
            }
            else{
                oneRight-=1;
            }
            output = Math.max(output,zeroLeft+oneRight);
        }
        return output;
    }
}