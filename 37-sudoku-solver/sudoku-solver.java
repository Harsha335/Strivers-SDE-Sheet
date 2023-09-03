class Solution {
    int rowSet[];
    int colSet[];
    int square[][];
    boolean isPossible(char[][] board,int i,int j,int ele)
    {
        return ((rowSet[i]&(1<<ele))==0 && (colSet[j]&(1<<ele))==0 && (square[i/3][j/3]&(1<<ele))==0);
    }
    boolean helper(char[][] board)
    {
        // System.out.println(ii+" "+jj);
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]=='.')
                {
                    for(int ele=1;ele<10;ele++)
                    {
                        if(isPossible(board,i,j,ele))
                        {
                            // System.out.println(i+"-"+j+" "+Integer.toBinaryString(rowSet[i])+" "+Integer.toBinaryString(colSet[j])+" "+Integer.toBinaryString(square[i/3][j/3])+" "+ele );
                            board[i][j]=(char)(ele+'0');
                            rowSet[i]=(rowSet[i]^(1<<ele));
                            colSet[j]=(colSet[j]^(1<<ele));
                            square[i/3][j/3]^=(1<<ele);
                            if(helper(board))
                                return true;
                            rowSet[i]=(rowSet[i]^(1<<ele));
                            colSet[j]=(colSet[j]^(1<<ele));
                            square[i/3][j/3]^=(1<<ele);
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
        rowSet=new int[10];
        colSet=new int[10];
        square=new int[3][3];
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {

                    rowSet[i]=(rowSet[i]|(1<<(board[i][j]-'0')));
                    colSet[j]=(colSet[j]|(1<<(board[i][j]-'0')));
                    square[i/3][j/3]=(square[i/3][j/3]|(1<<(board[i][j]-'0')));
                }
            }
        }
        helper(board);
    }
}