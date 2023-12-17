class FoodRatings {
    class Pair{
        String food;
        int rating;
        Pair(String f,int r)
        {
            food=f;
            rating=r;
        }
    }
    HashMap<String,PriorityQueue<Pair>> map=new HashMap<>();
    HashMap<String,String> getCuisines=new HashMap<>();
    HashMap<String,Integer> getValue=new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n=foods.length;
        for(int i = 0; i < n ; i++)
        {
            map.putIfAbsent(cuisines[i],new PriorityQueue<>((a,b)->{
                if(a.rating==b.rating)
                    return a.food.compareTo(b.food);
                return b.rating-a.rating;
            }));
            map.get(cuisines[i]).add(new Pair(foods[i],ratings[i]));
            getCuisines.put(foods[i],cuisines[i]);
            getValue.put(foods[i],ratings[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        map.get(getCuisines.get(food)).add(new Pair(food,newRating));
        getValue.put(food,newRating);
    }
    
    public String highestRated(String cuisine) {
        Pair peek=map.get(cuisine).peek();
        while(peek.rating!=getValue.get(peek.food))
        {
            map.get(cuisine).poll();
            peek=map.get(cuisine).peek();
        }
        return peek.food;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */