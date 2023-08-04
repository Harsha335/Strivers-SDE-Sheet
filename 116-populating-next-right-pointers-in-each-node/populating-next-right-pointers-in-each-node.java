/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            Node pre=null;
            while(size-->0)
            {
                Node cur=q.poll();
                if(cur==null)
                    continue;
                if(pre!=null) pre.next=cur;
                pre=cur;
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        return root;
    }
}