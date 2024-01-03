class Solution {
    int mm, nn, values;
    HashMap<Integer,Integer> mapIndex;  //index,value
    // List<Integer> list;
    int size;
    public Solution(int m, int n) {
        mm = m;
        nn = n;
        values = Math.min(1000, m*n);
        size = values;
        mapIndex = new HashMap<>();
        // list = new ArrayList<>();
        // for(int i = 0; i<values; i++)
        // {
        //     list.add(i);
        //     mapIndex.put(i, i);
        // }
    }
    
    public int[] flip() {
        Random rand = new Random();
        int randInd = rand.nextInt(size);
        // int randEle = list.get(randInd);
        // System.out.println(randInd);
        int randEle = mapIndex.getOrDefault(randInd , randInd);
        // System.out.println("hi");
        mapIndex.put(randInd, mapIndex.getOrDefault(size-1, size-1));
        // list.set(randInd, list.get(size-1));
        // list.remove(size-1);
        // mapIndex.remove(randEle);
        size --;
        return new int[]{randEle/nn, randEle%nn};
    }
    
    public void reset() {
        size = values;
        mapIndex.clear();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */