class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    int l,r;
    public MedianFinder() {
        left=new PriorityQueue<>((a,b)->b-a);
        right=new PriorityQueue<>((a,b)->a-b);
        l=0;
        r=0;
    }
    public void addNum(int num) {
        if(l==r)
        {
            right.add(num);
            left.add(right.poll());
            l+=1;
        }
        else{
            left.add(num);
            right.add(left.poll());
            r+=1;
        }
    }
    
    public double findMedian() {
        if(l==r)return (double)(left.peek()+right.peek())/2;
        return left.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */