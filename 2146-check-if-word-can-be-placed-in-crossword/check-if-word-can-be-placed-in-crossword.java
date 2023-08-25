class Solution {
    int n,m;
    int len;
    boolean topCheck(int i,int j,char[][] board,String word)
    {
        int ind=0;
        while(i<n && ind<len)
        {
            if(board[i][j]!=' ' && board[i][j]!=word.charAt(ind))
                return false;
            i++;
            ind++;
        }
        return ind==len && (i==n || board[i][j]=='#');
    }
    boolean leftCheck(int i,int j,char[][] board,String word)
    {
        int ind=0;
        while(j<m && ind<len)
        {
        // System.out.println(i+"---- "+j);
            if(board[i][j]!=' ' && board[i][j]!=word.charAt(ind))
                return false;
            j++;
            ind++;
        }
        return ind==len && (j==m || board[i][j]=='#');
    }
    boolean bottomCheck(int i,int j,char[][] board,String word)
    {
        int ind=0;
        while(i>=0 && ind<len)
        {
            if(board[i][j]!=' ' && board[i][j]!=word.charAt(ind))
                return false;
            i--;
            ind++;
        }
        return ind==len && (i==-1 || board[i][j]=='#');
    }
    boolean rightCheck(int i,int j,char[][] board,String word)
    {
        int ind=0;
        // System.out.println(i+" "+j);
        while(j>=0 && ind<len)
        {
            if(board[i][j]!=' ' && board[i][j]!=word.charAt(ind))
                return false;
            j--;
            ind++;
        }
        return ind==len && (j==-1 || board[i][j]=='#');
    }
    public boolean placeWordInCrossword(char[][] board, String word) {
        n=board.length;
        m=board[0].length;
        len=word.length();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]!='#')
                {
                    // System.out.println(i+" "+j);
                    if(i==0 || board[i-1][j]=='#')  //top bottom
                    {
                        if(topCheck(i,j,board,word)) return true;
                    }
                    if(j==0 || board[i][j-1]=='#')  //left
                    {
                        if(leftCheck(i,j,board,word)) return true;
                    }
                    if(i==n-1 || board[i+1][j]=='#')  //right
                    {
                        if(bottomCheck(i,j,board,word)) return true;
                    }
                    if(j==m-1 || board[i][j+1]=='#')  //bottom top
                    {
                        if(rightCheck(i,j,board,word)) return true;
                    }
                }
            }
        }
        return false;
    }
}