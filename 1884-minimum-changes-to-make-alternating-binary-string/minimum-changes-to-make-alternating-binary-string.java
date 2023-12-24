class Solution {
    public int minOperations(String s) {
        int count1=0;
        int count2=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                count1+=(s.charAt(i)=='0')?0:1;
                count2+=(s.charAt(i)=='0')?1:0;
            }
            else{
                count1+=(s.charAt(i)=='1')?0:1;
                count2+=(s.charAt(i)=='1')?1:0;
            }
        }
        return Math.min(count1,count2);
    }
}