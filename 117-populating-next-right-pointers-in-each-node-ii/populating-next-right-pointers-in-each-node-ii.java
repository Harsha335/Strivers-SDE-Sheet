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
        if(root==null)return root;
        Queue<Node> level=new LinkedList<>();
        level.add(root);
        while(!level.isEmpty())
        {
            int size=level.size();
            Node pree=null;
            while(size-->0)
            {
                Node node=level.poll();
                if(node.left!=null)
                {
                    if(pree!=null)
                    {
                        pree.next=node.left;
                    }
                    pree=node.left;
                    level.add(node.left);
                }
                if(node.right!=null)
                {
                    if(pree!=null)
                    {
                        pree.next=node.right;
                    }
                    pree=node.right;
                    level.add(node.right);
                }
            }
        }
        return root;
    }
}