class Solution {
    public int bulbSwitch(int n) {
        int count=0;
        for(int i=1;i<=n;i++)
        {
            if(Math.sqrt(i)==Math.floor(Math.sqrt(i))) count++;
        }
        return count;
    }
}