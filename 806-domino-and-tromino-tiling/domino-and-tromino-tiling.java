class Solution {
    // HashMap<Integer,List<Integer>> map;
    // private int helper(int n,int col,int state)
    // {
    //     if((col==n && state==3) || (col==n+1 && state==0))
    //         return 1;
    //     int count=0;
    //     for(int x:map.get(state))
    //     {
    //         count+=helper(n,col+1,x);
    //     }
    //     return count;
    // }
    public int numTilings(int n) {
        // map=new HashMap<>();
        // for(int i=0;i<4;i++)
        // {
        //     map.put(i,new ArrayList<>());
        // }
        // map.get(0).addAll(Arrays.asList(1,2,0));    //0 EMPTY 1 DOWN-FILL 2 UP-FILL 3-FILLED
        // map.get(1).addAll(Arrays.asList(2,3));
        // map.get(2).addAll(Arrays.asList(1,3));
        // map.get(3).addAll(Arrays.asList(0));
        // //0 0 - 1,2,0
        // //1 0 - 
        // return helper(n,0,0);
        int arr[]=new int[n];
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 5;
        arr[0]=1;arr[1]=2;arr[2]=5;
        for(int i=3;i<n;i++)
        {
            // System.out.println(arr[i-1]+" "+arr[i-3]);
            arr[i]=(2*arr[i-1])%((int)1e9+7)+arr[i-3];
            arr[i]=(arr[i])%((int)1e9+7);
        }
        return arr[n-1];
    }
}