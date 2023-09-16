class Solution {
    int dir[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    int n,m;
    boolean isPossible(int target,int[][] heights,int i,int j,boolean visited[][])
    {
        // System.out.println(i+"-"+j+" "+target);
        if(i==n-1 && j==m-1)
            return true;
        visited[i][j]=true;
        for(int []d:dir)
        {
            int x=d[0]+i;
            int y=d[1]+j;
            if(x>=0 && y>=0 && x<n && y<m && !visited[x][y] && Math.abs(heights[i][j]-heights[x][y])<=target)
            {
                if(isPossible(target,heights,x,y,visited))
                    return true;
            }
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {
        int mini=(int)1e5;
        int maxi=0;
        n=heights.length;
        m=heights[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mini=Math.min(heights[i][j],mini);
                maxi=Math.max(heights[i][j],maxi);
            }
        }
        // System.out.println(mini+" "+maxi);
        int low=0;
        int high=(maxi-mini);
        // int ans=0;
        while(low<high)
        {
            int mid=(low+(high-low)/2);
            boolean visited[][]=new boolean[n][m];
            if(isPossible(mid,heights,0,0,visited))
            {
                high=mid;
            }
            else
                low=mid+1;
        }
        return high;
    }
}