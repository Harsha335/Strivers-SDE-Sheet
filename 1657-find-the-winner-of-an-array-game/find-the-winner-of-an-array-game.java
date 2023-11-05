class Solution {
    public int getWinner(int[] arr, int k) {
        int wins=0;
        int winner=arr[0];
        int n=arr.length;
        for(int i=1;i<n;i++)
        {
            if(winner>arr[i])
            {
                wins++;
            }
            else{
                wins=1;
                winner=arr[i];
            }
            if(wins==k)
                return winner;
        }
        return winner;
    }
}