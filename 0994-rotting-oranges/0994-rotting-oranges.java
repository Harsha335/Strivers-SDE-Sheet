class Solution {
    int n,m;
    public boolean isValid(int x,int y)
    {
        return x>=0 && y>=0 && x<n && y<m;
    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        n=grid.length;
        m=grid[0].length;
        int goodOranges=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
                if(grid[i][j]==1)
                {
                    goodOranges++;
                }
            }
        }
        int time=0;
        int directions[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.isEmpty())
        {
            int size=q.size();
            boolean isHappend=false;
            while(size-->0)
            {
                int x=q.peek()[0];
                int y=q.peek()[1];
                q.poll();
                for(int dir[]:directions)
                {
                    int curx=x+dir[0];
                    int cury=y+dir[1];
                    if(isValid(curx,cury) && grid[curx][cury]==1)
                    {
                        q.add(new int[]{curx,cury});
                        goodOranges--;
                        isHappend=true;
                        grid[curx][cury]=2;
                    }
                }
            }
            if(!isHappend)
                break;
            time++;
        }
        return goodOranges==0?time:-1;
    }
}