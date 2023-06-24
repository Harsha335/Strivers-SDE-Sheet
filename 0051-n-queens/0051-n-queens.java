class Solution {
    List<List<String>> output;
    char board[][];
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
    void helper(int row,int n)
    {
        if(row==n)
        {
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
//                 StringBuilder s=new StringBuilder();
//                 for(int j=0;j<n;j++)
//                 {
                    
//                     if(board[i][j]==1)
//                         s.append("Q");
//                     else
//                         s.append(".");
//                 }
//                 list.add(s.toString());
                list.add(new String(board[i]));
            }
            // System.out.println(list);
            output.add(list);
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(isSafe(row,col,n))
            {
                rowVisit[row]=true;
                colVisit[col]=true;
                diagonalVisit1[col-row+n-1]=true;// diagonal - \
                diagonalVisit2[n-1-col-row+n-1]=true;// diagonal - /
                board[row][col]='Q';
                 
                helper(row+1,n);

                board[row][col]='.';
                rowVisit[row]=false;
                colVisit[col]=false;
                diagonalVisit1[col-row+n-1]=false;
                diagonalVisit2[n-1-col-row+n-1]=false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        output=new ArrayList<>();
        board=new char[n][n];
        for(char[] x:board)
            Arrays.fill(x,'.');
        rowVisit=new boolean[n];
        colVisit=new boolean[n];
        diagonalVisit1=new boolean[2*n-1];
        diagonalVisit2=new boolean[2*n-1];
        helper(0,n);
        return output;
    }
}