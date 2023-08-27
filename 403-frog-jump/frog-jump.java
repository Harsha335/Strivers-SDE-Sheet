class Solution {
    int search(int[] stones,int ele,int i,int j)
    {
            // System.out.println(ele);
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            // System.out.println(i+" "+j+" "+mid+" "+stones[mid]);
            if(stones[mid]==ele) return mid;
            if(stones[mid]>ele) j=mid-1;
            else i=mid+1;
        }
        return -1;
    }
    int dp[][];
    boolean helper(int[] stones,int ind,int step,int end)
    {
        if(ind==end-1) return true;
        if(dp[ind][step]!=-1) return false;
        for(int st=Math.max(1,step-1);st<step+2;st++)
        {
            // System.out.println(ind+" "+st+" "+step);
            int indi=search(stones,stones[ind]+st,ind,end-1);
            // System.out.println("- "+indi+"-");
            if(indi!=-1)
            {
                if(helper(stones,indi,st,end))
                    return true;
            }
        }
        dp[ind][step]=0;
        return false;
    }
    public boolean canCross(int[] stones) {
        if(stones[1]!=1)
            return false;
        int n=stones.length;
        dp=new int[n][n+2];
        for(int x[]:dp)
        {
            Arrays.fill(x,-1);
        }
        return helper(stones,1,1,n);
    }
}