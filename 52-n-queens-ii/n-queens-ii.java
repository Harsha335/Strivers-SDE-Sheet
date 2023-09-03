class Solution {
    int board[][];
    boolean rowVisit[];
    boolean colVisit[];
    boolean diagonalVisit1[];
    boolean diagonalVisit2[];
    boolean isSafe(int row,int col,int n)
    {
        // System.out.println(row+" "+col+" "+n+" "+(col-row+n)+" "+(n-1-col-row+n) );
        return !rowVisit[row] && !colVisit[col] && !diagonalVisit1[col-row+n-1]
         && !diagonalVisit2[n-1-col-row+n-1];
    }
    int helper(int row,int n)
    {
        if(row==n)
        {
            return 1;
        }
        int ans=0;
        for(int col=0;col<n;col++)
        {
            if(isSafe(row,col,n))
            {
                rowVisit[row]=true;
                colVisit[col]=true;
                diagonalVisit1[col-row+n-1]=true;// diagonal - \
                diagonalVisit2[n-1-col-row+n-1]=true;
                board[row][col]=1;
                 
                ans+=helper(row+1,n);

                board[row][col]=0;
                rowVisit[row]=false;
                colVisit[col]=false;
                diagonalVisit1[col-row+n-1]=false;
                diagonalVisit2[n-1-col-row+n-1]=false;
            }
        }
        return ans;
    }
    public int totalNQueens(int n) {
        board=new int[n][n];
        rowVisit=new boolean[n];
        colVisit=new boolean[n];
        diagonalVisit1=new boolean[2*n-1];
        diagonalVisit2=new boolean[2*n-1];
        return helper(0,n);
        // return output;
    }
}