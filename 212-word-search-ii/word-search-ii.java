class Solution {
    class Trie{
        Trie[] child;
        String word;
        Trie()
        {
            child=new Trie[26];
            word=null;
        }
    }
    int n,m;
    List<String> output;
    int dir[][]=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    void helper(char[][] board,int i,int j,Trie root,boolean visited[][]){
        char ch=board[i][j];
        // System.out.println(i+" "+j);
        visited[i][j]=true;
        
        // if(root.child[ch-'a']==null)
        // {
        //     return;
        // }
        // System.out.println(i+" "+j+" "+root.child[ch-'a']);
        if(root.child[ch-'a'].word!=null)
        {
            // System.out.println(i+"-"+j);
            output.add(root.child[ch-'a'].word);
            root.child[ch-'a'].word=null;
        }
        for(int d[]:dir)
        {
            int x=d[0]+i;
            int y=d[1]+j;
            if(x>=0 && x<n && y>=0 && y<m && !visited[x][y] && root.child[ch-'a'].child[board[x][y]-'a']!=null)
            {
                helper(board,x,y,root.child[ch-'a'],visited);
            }
        }
        visited[i][j]=false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie root=new Trie();
        output=new ArrayList<>();
        for(String s:words)
        {
            Trie temp=root;
            // Trie pre=temp;
            for(char ch:s.toCharArray())
            {
                if(temp.child[ch-'a']==null)
                {
                    temp.child[ch-'a']=new Trie();
                }
                // pre=temp;
            // System.out.println(temp.child['d'-'a']);
                temp=temp.child[ch-'a'];
            }
            temp.word=s;
        }
        n=board.length;
        m=board[0].length;
        // System.out.println(n+" "+m);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                // System.out.println(i+"---"+j);
                char ch=board[i][j];
                if(root.child[ch-'a']!=null)
                    helper(board,i,j,root,new boolean[n][m]);
            }
        }
        return output;
    }
}