class SeatManager {
    private int curr;
    private PriorityQueue<Integer> pq;
    public SeatManager(int n) {
        curr=1;
        pq=new PriorityQueue<>();
    }
    
    public int reserve() {
        if(pq.size()==0)
        {
            return curr++;
        }
        return pq.poll();
    }
    
    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */