class Solution {
    Map<String, PriorityQueue<String>> map;
    List<String> result;

    private void dfs(String airport) {
        // System.out.println(map);
        PriorityQueue<String> destinations = map.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport);
        }
        result.add(0, airport); // Add the airport to the beginning of the result list.
        // System.out.println(result);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        result = new ArrayList<>();

        // Build the graph.
        for (List<String> ticket : tickets) {
            map.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        // Start the DFS from JFK.
        dfs("JFK");

        return result;
    }
}


// class Solution {
//     HashMap<String,PriorityQueue<String>> map;
//     HashMap<String,Integer> visited;
//     List<String> helper(String curr,int count,List<String> list)
//     {
//         // System.out.println(list);
//         if(count==0)
//             return list;
//         if(!map.containsKey(curr))return null;
//         int ind=0;
//         for(String x:map.get(curr))
//         {
//         // System.out.println(((1<<ind)+" "+visited.get(curr)));
//             if(((1<<ind)&visited.get(curr))==0)
//             {
//                 visited.put(curr,visited.get(curr)^(1<<ind));
//                 list.add(x);
//                 List<String> out=helper(x,count-1,list);
//                 if(out!=null)
//                     return out;
//                 list.remove(list.size()-1);
//                 visited.put(curr,visited.get(curr)^(1<<ind));
//             }
//             ind++;
//         }
//         return null;
//     }
//     public List<String> findItinerary(List<List<String>> tickets) {
//         map=new HashMap<>();
//         visited=new HashMap<>();
//         for(List<String> x :tickets)
//         {
//             map.putIfAbsent(x.get(0),new PriorityQueue<>());
//             map.get(x.get(0)).add(x.get(1));
//             visited.putIfAbsent(x.get(0),0);
//         }
//         List<String> output=new ArrayList<String>();
//         // System.out.println(map);
//         output.add("JFK");
//         return helper("JFK",tickets.size(),output);
        
//     }
// }


// class Solution {
//   // origin -> list of destinations
//   HashMap<String, List<String>> flightMap = new HashMap<>();
//   HashMap<String, boolean[]> visitBitmap = new HashMap<>();
//   int flights = 0;
//   List<String> result = null;


//   public List<String> findItinerary(List<List<String>> tickets) {
//     // Step 1). build the graph first
//     for (List<String> ticket : tickets) {
//       String origin = ticket.get(0);
//       String dest = ticket.get(1);
//       if (this.flightMap.containsKey(origin)) {
//         List<String> destList = this.flightMap.get(origin);
//         destList.add(dest);
//       } else {
//         List<String> destList = new LinkedList<String>();
//         destList.add(dest);
//         this.flightMap.put(origin, destList);
//       }
//     }

//     // Step 2). order the destinations and init the visit bitmap
//     for (Map.Entry<String, List<String>> entry : this.flightMap.entrySet()) {
//       Collections.sort(entry.getValue());
//       this.visitBitmap.put(entry.getKey(), new boolean[entry.getValue().size()]);
//     }

//     this.flights = tickets.size();
//     LinkedList<String> route = new LinkedList<String>();
//     route.add("JFK");

//     // Step 3). backtracking
//     this.backtracking("JFK", route);
//     return this.result;
//   }

//   protected boolean backtracking(String origin, LinkedList<String> route) {
//     if (route.size() == this.flights + 1) {
//       this.result = (List<String>) route.clone();
//       return true;
//     }

//     if (!this.flightMap.containsKey(origin))
//       return false;

//     int i = 0;
//     boolean[] bitmap = this.visitBitmap.get(origin);

//     for (String dest : this.flightMap.get(origin)) {
//       if (!bitmap[i]) {
//         bitmap[i] = true;
//         route.add(dest);
//         boolean ret = this.backtracking(dest, route);
//         route.pollLast();
//         bitmap[i] = false;

//         if (ret)
//           return true;
//       }
//       ++i;
//     }

//     return false;
//   }
// }