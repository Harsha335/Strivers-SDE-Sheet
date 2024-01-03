class Solution {
    int mm, nn, values;
    HashMap<Integer,Integer> mapIndex;
    List<Integer> list;
    int size;
    public Solution(int m, int n) {
        mm = m;
        nn = n;
        values = Math.min(1000, m*n);
        size = values;
        mapIndex = new HashMap<>();
        list = new ArrayList<>();
        for(int i = 0; i<values; i++)
        {
            list.add(i);
            mapIndex.put(i, i);
        }
    }
    
    public int[] flip() {
        Random rand = new Random();
        int randInd = rand.nextInt(size);
        int randEle = list.get(randInd);
        // System.out.println(randInd+" "+randEle);
        mapIndex.put(list.get(size-1), randInd);
        list.set(randInd, list.get(size-1));
        list.remove(size-1);
        mapIndex.remove(randEle);
        size --;
        // System.out.println(list);
        // System.out.println(mapIndex);
        return new int[]{randEle/nn, randEle%nn};
    }
    
    public void reset() {
        size = values;
        mapIndex = new HashMap<>();
        list = new ArrayList<>();
        for(int i = 0; i<values; i++)
        {
            list.add(i);
            mapIndex.put(i, i);
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */