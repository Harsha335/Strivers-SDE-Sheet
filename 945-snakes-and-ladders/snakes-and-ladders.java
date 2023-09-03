class Solution {
    int n;
    int[] getRowCol(int num){
        int r=(num-1)/n;
        int c=(num-1)%n;
        // System.out.println(r+"-"+c);
        // if(n%2==0){
            if((r)%2==0)
                return new int[]{n-1-r,c};
            return new int[]{n-1-r,n-1-c};
        // }
        // else{
        //     if((r)%2!=0)
        //         return new int[]{n-1-r,c};
        //     return new int[]{n-r-1,n-1-c};
        // }
    }
    public int snakesAndLadders(int[][] board) {
        n=board.length;
        // System.out.println(n);
        boolean visited[][]=new boolean[n][n];
        Queue<Integer> q=new LinkedList<>();
        // for(int i=n*n;i>0;i--){
        //     int[] y=getRowCol(i);
            // System.out.println(i+" "+y[0]+" "+y[1]);
        // }
        q.add(1);
        // visited[n-1][0]=true;
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            // System.out.println(q);
            // for(int j=0;j<n;j++){
            //     for(int k=0;k<n;k++){
            //         System.out.print(visited[j][k]+" ");
            //     }
            //     System.out.println();
            // }
            while(size-->0){
                int num=q.poll();
                int[] coo=getRowCol(num);
                // if(visited[coo[0]][coo[1]])
                //     continue;
                visited[coo[0]][coo[1]]=true;
                // System.out.println(coo[0]+" "+coo[1]+" "+num);
                int nextNum=num;
                // int[] nextCo=new int[]{n-1,0};
                for(int i=num+1;i<=num+6;i++){
                    int x[]=getRowCol(i);
                    if(i==(n*n) || board[x[0]][x[1]]==n*n)
                    {
                        return level+1;
                    }
                    if(board[x[0]][x[1]]==-1){
                        // System.out.println("HI"+" "+i+" "+x[0]+" "+x[1]);
                        // nextNum=i;
                        // nextCo[0]=x[0];
                        // nextCo[1]=x[1];
                        if(!visited[x[0]][x[1]]){
                            // System.out.println(nextNum);
                            q.add(i);
                            visited[x[0]][x[1]]=true;
                        }
                    }
                    else
                    {
                        int[] co=getRowCol(board[x[0]][x[1]]);
                        if(!visited[co[0]][co[1]]){
                            q.add(board[x[0]][x[1]]);
                            visited[co[0]][co[1]]=true;
                        }
                    }
                }
                // if(!visited[nextCo[0]][nextCo[1]]){
                //     // System.out.println(nextNum);
                //     q.add(nextNum);
                //     visited[nextCo[0]][nextCo[1]]=true;
                // }
            }
            level+=1;
        }
        return -1;
        // int[] flatten=new int[n*n+1];
        // int ind=1;
        // for(int i=n-1;i>=0;i--)
        // {
        //     for(int j=((i%2==0)?0:n-1);j>=0 && j<n;)
        //     {
        //         flatten[ind++]=board[i][j];
        //         if(i%2==0)
        //             j++;
        //         else
        //             j--;
        //     }
        // }
        // q.add(1);
        // int level=0;
        // while(!q.isEmpty())
        // {
        //     int size=q.size();
        //     while(size-->0)
        //     {
        //         int ele=q.poll();
        //         if(ele==n*n)
        //             return level;
        //         for(int next=ele+1;next<=ele+6;next++)
        //         {
                    
        //         }
        //     }
        // }
        // return level;
    }
}