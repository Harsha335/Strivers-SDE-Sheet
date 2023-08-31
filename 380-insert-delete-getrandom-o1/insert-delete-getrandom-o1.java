class RandomizedSet {
    HashMap<Integer,Integer> map;   //value,index
    ArrayList<Integer> arr; //values
    int size;
    public RandomizedSet() {
        map=new HashMap<>();
        arr=new ArrayList<>();
        size=0;
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        arr.add(val);
        map.put(val,size);
        size++; 
        return true;       
    }
    void swap(ArrayList<Integer> arr,int i,int j)
    {
        int temp=arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);
    }
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int index=map.get(val);
        map.put(arr.get(size-1),index);
        swap(arr,index,size-1);
        map.remove(val);
        arr.remove(size-1);
        size--;
        return true;
    }
    
    public int getRandom() {
        Random rand=new Random();
        return arr.get(rand.nextInt(size));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */