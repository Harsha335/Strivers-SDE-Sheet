class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int isPossible=0;
        int n=gas.length;
        for(int i=0;i<n;i++)
        {
            isPossible+=(gas[i]-cost[i]);
        }
        if(isPossible<0)
            return -1;
        int total=0;
        int ans=0;
        for(int i=0;i<n;i++)
        {
            // since their is only one solution , the 1st positive number which reach end is the solution
            total+=(gas[i]-cost[i]);
            if(total<0)
            {
                total=0;
                ans=i+1;
            }
        }
        return ans;
    }
}