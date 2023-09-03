class Solution {
    int dir[][]=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    int n,m;
    int counter(int[][] board,int ii,int jj)
    {
        int count=0;
        for(int d[]:dir)
        {
            int x=ii+d[0];
            int y=jj+d[1];
            if(x>=0 && y>=0 && x<n && y<m && board[x][y]>=1)
            {
                count++;
            }
        }
        return count;
    }
    public void gameOfLife(int[][] board) {
        n=board.length;
        m=board[0].length;
        //making 1->1 die, 1->2 nextgen, 0->(-1) nextgen, 0->0 die
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int count=counter(board,i,j);
                if(board[i][j]==1)
                {
                    if(count==2 || count==3)
                        board[i][j]=2;
                }
                else{
                    if(count==3)
                        board[i][j]=-1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                board[i][j]=((board[i][j]==1)?0:(board[i][j]==0)?0:1);
            }
        }
    }
}