/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> pointer=new HashMap<>();
        Node cur=head;
        Node dummy=new Node(-1);
        Node tail=dummy;
        while(cur!=null)
        {
            Node node=new Node(cur.val);
            pointer.put(cur,node);
            tail.next=node;
            tail=tail.next;
            cur=cur.next;
        }
        //placing all random nodes for each node
        for(Node nodeOld:pointer.keySet())
        {
            Node nodeNew=pointer.get(nodeOld);
            Node nodeRandom=pointer.get(nodeOld.random);
            nodeNew.random=nodeRandom;
        }
        return dummy.next;
    }
}