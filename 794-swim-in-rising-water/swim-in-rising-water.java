class Solution {
    boolean isPossible(int[][] grid,int target)
    {
        int n=grid.length;
        boolean visited[][]=new boolean[n][n];
        Queue<List<Integer>> q=new LinkedList<>();
        if(grid[0][0]>target)return false;
        q.add(Arrays.asList(0,0));
        int dir[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        // int curr[]=new int[2];
        visited[0][0]=true;
        while(!q.isEmpty())
        {
            List<Integer> curr=q.poll();
            for(int[] d:dir)
            {
                int x=curr.get(0)+d[0];
                int y=curr.get(1)+d[1];
                // System.out.println(x>=0 && y>=0 && x<n && y<n && visited[x][y]);
                if(x>=0 && y>=0 && x<n && y<n && !visited[x][y] && grid[x][y]<=target)
                {
                    if(x==n-1 && y==n-1)return true;
                    visited[x][y]=true;
                    // curr[0]=x;curr[1]=y;
                    q.add(Arrays.asList(x,y));
                }
            }
                // System.out.println(q);
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        if(grid.length==1 && grid[0].length==1)return grid[0][0];
        int left=0;
        int right=2500;
        int output=2500;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(isPossible(grid,mid))
            {
                // System.out.println("yes");
                output=mid;
                right=mid-1;
            }
            else
                left=mid+1;
            // System.out.println(left+"-"+right);
        }
        return output;
    }
}