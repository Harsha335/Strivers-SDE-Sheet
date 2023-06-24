class Solution {
    int n;
    boolean isValid(char[][] board,char c,int i,int j)
    {
        int initailx=3*(i/3);
        int initaily=3*(j/3);
        for(int ind=0;ind<n;ind++)
        {
            // System.out.println(ind+" "+c);
            if(board[i][ind]==c)return false;
            if(board[ind][j]==c)return false;
            // System.out.println(i+" "+j+" "+(initailx+ind/3)+" "+(initaily+ind%3));
            if(board[initailx+ind/3][initaily+ind%3]==c)return false;
        }
        return true;
    }
    boolean helper(char[][] board)
    {
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='.')
                {
                    for(char c='1';c<='9';c++)
                    {
                        if(isValid(board,c,i,j))
                        {
                            board[i][j]=c;
                            if(helper(board))
                                return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
        n=9;
        helper(board);
    }
}