class Solution {
    public int trapRainWater(int[][] heightMap) {
        int n=heightMap.length;
        int m=heightMap[0].length;
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->heightMap[a.get(0)][a.get(1)]-heightMap[b.get(0)][b.get(1)]);
        boolean visited[][]=new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || i==n-1 || j==0 || j==m-1)
                {
                    pq.add(Arrays.asList(i,j));
                    visited[i][j]=true;
                }
            }
        }
        int dir[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        int output=0;
        while(!pq.isEmpty())
        {
            List<Integer> curr=pq.poll();
            for(int d[]:dir)
            {
                int x=d[0]+curr.get(0);
                int y=d[1]+curr.get(1);
                if(x>=0 && y>=0 && x<n && y<m && !visited[x][y])
                {
                    output+=Math.max(0,heightMap[curr.get(0)][curr.get(1)]-heightMap[x][y]);
                    heightMap[x][y]=Math.max(heightMap[curr.get(0)][curr.get(1)],heightMap[x][y]);
                    pq.add(Arrays.asList(x,y));
                    visited[x][y]=true;
                }
            }
        }
        return output;
    }
}