class Solution {
    class Trie {
        char c;
        int times;
        Map<Pair, Trie> children;
        List<String> list;

        Trie(char c, int times) {
            this.c = c;
            this.times = times;
            children = new HashMap<>();
            list = new ArrayList<>();
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
        Trie tree = new Trie('.', 0);

        for (int i = 0; i < n; i++) {
            TreeMap<Character, Integer> counter = new TreeMap<>();
            getCounter(strs[i], counter);
            Trie ptrT = tree;

            for (char ch : counter.keySet()) {
                int times = counter.get(ch);
                
                Pair pair = new Pair(ch, times);
                if (!ptrT.children.containsKey(pair)) {
                    Trie node = new Trie(ch, times);
                    ptrT.children.put(pair, node);
                }

                ptrT = ptrT.children.get(pair);
            }

            if (ptrT.list.isEmpty()) {
                output.add(ptrT.list);
            }

            ptrT.list.add(strs[i]);
        }

        return output;
    }
}