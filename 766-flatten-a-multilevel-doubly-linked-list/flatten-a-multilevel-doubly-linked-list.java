/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node helper(Node temp)
    {
        Node pre=temp;
        while(temp!=null)
        {
            Node nexty=temp.next;
            if(temp.child!=null)
            {
                temp.next=temp.child;
                temp.child.prev=temp;
                temp.child=null;
                Node last=helper(temp.next);
                last.next=nexty;
                if(nexty!=null)
                    nexty.prev=last;
                pre=last;
            }
            else
                pre=temp;
            temp=nexty;
        }
        // System.out.println(pre==null?"null":pre.val);
        return pre;
    }
    public Node flatten(Node head) {
        helper(head);
        return head;
    }
}