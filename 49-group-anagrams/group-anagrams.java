class Solution {
    // class Pair {
    //     char c;
    //     int times;
    //     List<Trie> children;

    //     Pair(char c, int times) {
    //         this.c = c;
    //         this.times = times;
    //         children = new ArrayList<>();
    //     }

    //     @Override
    //     public int hashCode() {
    //         return Objects.hash(c, times);
    //     }

    //     @Override
    //     public boolean equals(Object obj) {
    //         if (this == obj) return true;
    //         if (obj == null || getClass() != obj.getClass()) return false;
    //         Pair pair = (Pair) obj;
    //         return c == pair.c && times == pair.times;
    //     }
    // }

    class Trie {
        // List<Pair> ele;
        char c;
        int times;
        List<Trie> children; 
        List<String> list;

        // Trie(Pair x) {
        //     ele = new ArrayList<>();
        //     ele.add(x);
        //     list = new ArrayList<>();
        // }
        Trie(char c,int times)
        {
            this.c=c;
            this.times=times;
            children=new ArrayList<>();
            list=new ArrayList<>();
        }
    }

    void getCounter(String s, TreeMap<Character, Integer> counter) {
        for (char ch : s.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> output = new ArrayList<>();
        Trie tree =new Trie('.',0);
        
        for (int i = 0; i < n; i++) {
            TreeMap<Character, Integer> counter = new TreeMap<>();
            getCounter(strs[i], counter);
            Trie ptrT = tree;
            for (char ch : counter.keySet()) {
                int times = counter.get(ch);
                boolean isFound=false;
                for(Trie x:ptrT.children)
                {
                    if(x.c==ch && x.times==times)
                    {
                        ptrT=x;
                        isFound=true;
                        break;
                    }   
                }
                if(!isFound)
                {
                    Trie node=new Trie(ch,times);
                    ptrT.children.add(node);
                    ptrT=node;
                }
                    // boolean isFound = false;
                    // List<Pair> pairs = ptrT.ele;
                    // Pair pair = new Pair(ch, times);
                    
                    // for (Pair p : pairs) {
                    //     if (p.equals(pair)) {
                    //         isFound = true;
                    //         ptrT = p.children.get(0); // Assuming each pair has only one child in your structure
                    //         break;
                    //     }
                    // }
                    
                    // if (!isFound) {
                    //     Pair newPair = new Pair(ch, times);
                    //     Trie newTrie = new Trie(newPair);
                    //     pairs.add(newPair);
                    //     ptrT = newTrie;
                    // }
            }
            
            if (ptrT.list.isEmpty()) {
                output.add(ptrT.list);
            }
            
            ptrT.list.add(strs[i]);
        }
        
        return output;
    }
}
