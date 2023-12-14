class Solution {
    public int minimumOneBitOperations(int n) {
        int output=0;
        int mask=1;
        int index=0;
        while(mask<=n)
        {
            if((mask&n)!=0)
            {
                output=((1<<(index+1))-1)-output;
            }
            mask<<=1;
            index++;
        }
        return output;
    }
}