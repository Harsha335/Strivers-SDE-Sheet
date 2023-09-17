class Solution {
    class Pair{
        int vertex;
        int mask;
        Pair(int vertex,int mask){
            this.vertex=vertex;
            this.mask=mask;
        }
        @Override
        public int hashCode(){
            return 7+this.vertex+this.mask;
        }
        @Override
        public boolean equals(Object obj){
            // if(this==obj)return true;
            // if(obj==null)return false;
            Pair object=(Pair)obj;
            if(this.vertex!=object.vertex || this.mask!=object.mask){
                return false;
            }
            return true;
        }
    }
    public int shortestPathLength(int[][] graph) {
     HashSet<Pair> visited=new HashSet<>();
     Queue<Pair> q=new LinkedList<>();
     int n=graph.length;
     int allvisit=(1<<n)-1;
     for(int i=0;i<n;i++){
         q.add(new Pair(i,1<<i));
         visited.add(new Pair(i,1<<i));
        //  if(1<<i==allvisit){
        //      return 0;
        //  }
     }   
     int level=0;
     while(!q.isEmpty()){
         int size=q.size();
         while(size-->0)
         {
            int vertex=q.peek().vertex;
            int mask=q.peek().mask;
            q.poll();
            for(int x:graph[vertex]){
                // int ver=x;
                int newMask=mask|1<<x;
                if(newMask==allvisit)
                    return level+1;
                Pair newObj=new Pair(x,newMask);
                if(!visited.contains(newObj)){
                    visited.add(newObj);
                    q.add(newObj);
                }
            }
         }
         level+=1;
     }
     return 0;
    }
}