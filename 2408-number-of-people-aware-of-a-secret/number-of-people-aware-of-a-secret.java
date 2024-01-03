class Solution {
    public int peopleAwareOfSecret(int n, int d, int f) {    
        Long sharing = 0l;
        int mod = (int)1e9+7;
        Queue<Long> delay = new LinkedList<>();
        delay.add(1L);
        Queue<Long> forget = new LinkedList<>();
        forget.add(1L);
        for(int i = 1; i< n; i++)
        {
            if(delay.size() >= d){
                sharing = (sharing + delay.poll())%mod;
            }
            if(forget.size() >= f){
                sharing = (mod + sharing - forget.poll())%mod;
            }
            delay.add(sharing);
            forget.add(sharing);
        }
        long sum = 0;
        for(long ele: forget)
            sum = (sum + ele)%mod;
        return (int)sum;
    }
}