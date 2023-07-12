class StockSpanner {
    Stack<int[]> st;
    int ind;
    public StockSpanner() {
        st=new Stack<>();
        ind=-1;
    }
    
    public int next(int price) {
        while(!st.isEmpty() && st.peek()[0]<=price)
        {
            st.pop();
        }
        ind++;
        int span=1;
        if(st.isEmpty())
        {
            span=ind+1;
        }
        else
            span=ind-st.peek()[1];
        st.push(new int[]{price,ind});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */