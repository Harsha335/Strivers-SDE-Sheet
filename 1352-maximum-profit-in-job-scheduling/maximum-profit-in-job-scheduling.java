class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int maxTime = 0;
        int n = startTime.length;
        int map[][] = new int[n][3];
        for(int i = 0; i < n; i++)
        {
            map[i][0] = startTime[i];
            map[i][1] = endTime[i];
            map[i][2] = profit[i];
            maxTime = Math.max(maxTime, endTime[i]);
        }
        Arrays.sort(map, (a,b)->{
            if(a[1] != b[1])
                return a[1] - b[1];
            return a[2] - b[2];//no need (our priority is end point)
        });
        // for(int x[]: map)
        //  System.out.println(Arrays.toString(x));
        // int dp[] = new int[maxTime + 1];    // Memory limit exceedes
        TreeMap<Integer,Integer> dp = new TreeMap<>();
        // dp[0] = 0;
        dp.put(0 , 0);
        // int ind = 0;
        int output = 0;
        // for(int i = 1; i <= maxTime; i++)
        for(int i = 0; i < n; i++)
        {
            // System.out.println(ind);
            int prevValue = dp.get(dp.floorKey(map[i][1]));
            // System.out.println(i+" "+prevValue);
            dp.put(map[i][1], Math.max(dp.get(dp.floorKey(map[i][0])) + map[i][2], prevValue));
            output = Math.max(dp.get(map[i][1]), output);
        }
        return output;
    }
}

// [4,2,4,8,2]
// [5,5,5,10,8]
// [1,2,8,10,4]

// [33,8,9,18,16,36,18,4,42,45,29,43]
// [40,16,32,39,46,43,28,13,44,46,39,44]
// [2,6,5,14,5,19,5,12,19,14,14,17]

// [6,15,7,11,1,3,16,2]
// [19,18,19,16,10,8,19,8]
// [2,9,1,19,5,7,3,19]