class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        boolean visited[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(isWater[i][j] == 1)
                {
                    visited[i][j] = true;
                    q.add(new int[]{i,j});
                    isWater[i][j] = 0;
                }
            }
        }
        int dir[][] = new int[][]{{-1, 0}, {0, 1}, {0, -1}, {1, 0}};
        int level = 1;
        while(!q.isEmpty())
        {
            int size = q.size();
            // System.out.println(level);
            while(size-- > 0)
            {
                int curr[] = q.poll();
                // System.out.println(curr[0]+" "+curr[1]);
                for(int d[]:dir)
                {
                    int x = d[0]+curr[0];
                    int y = d[1]+curr[1];
                    if(x >= 0 && x < n && y >= 0 && y < m && !visited[x][y])
                    {
                        visited[x][y] = true;
                        q.add(new int[]{x, y});
                        isWater[x][y] = level;
                    }
                }
            }
            level ++;
        }
        return isWater;
    }
}