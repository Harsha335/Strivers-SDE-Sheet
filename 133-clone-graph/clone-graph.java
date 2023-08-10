/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        Node root=null;
        HashSet<Node> visited=new HashSet<>();
        while(!q.isEmpty())
        {
            Node ele=q.poll();
            map.putIfAbsent(ele.val,new Node(ele.val));
            if(root==null) root=map.get(ele.val);
            // System.out.println(ele.val);
            visited.add(ele);
            for(Node x:ele.neighbors)
            {
                map.putIfAbsent(x.val,new Node(x.val));
                map.get(ele.val).neighbors.add(map.get(x.val));
                if(!visited.contains(x)){
                    q.add(x);
                    visited.add(x);
                } 
            }
            // System.out.println(map.get(ele.val).neighbors);
        }
        return root;
    }
}