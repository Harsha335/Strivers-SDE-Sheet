class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=colors.length();
        int maxi=neededTime[0];
        int curr=neededTime[0];
        int output=0;
        for(int i=1;i<n;i++)
        {
            if(colors.charAt(i)==colors.charAt(i-1))
            {
                maxi=Math.max(maxi,neededTime[i]);
                curr+=neededTime[i];
                // System.out.println(maxi+" "+curr);
            }
            else{
                output+=curr-maxi;
                curr=neededTime[i];
                maxi=neededTime[i];
            }
        }
        return output+curr-maxi;
    }
}