class Solution {
    public int findCenter(int[][] edges) {
        int common=-1;
        for(int ele:edges[0])
        {
            for(int ele2:edges[1])
                if(ele==ele2)
                {
                    common=ele;
                    break;
                }
        }
        return common;
    }
}