class DataStream {
    int k, value, count;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        count = 0;
    }
    
    public boolean consec(int num) {
        if(num == value)
            count = Math.min(count+1, k);
        else
            count = 0;
        return count == k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */