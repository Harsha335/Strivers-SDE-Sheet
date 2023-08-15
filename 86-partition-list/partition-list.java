/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    void removeAndInsert(ListNode temp,ListNode cur,ListNode pre)
    {
        pre.next=cur.next;
        cur.next=temp.next;
        temp.next=cur;
    }
    public ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        head=dummy;
        ListNode temp=dummy;
        while(temp.next!=null && temp.next.val<x)
            temp=temp.next;
        ListNode cur=temp.next;
        ListNode pre=null;
        while(cur!=null)
        {
            if(cur.val<x)
            {
                removeAndInsert(temp,cur,pre);
                temp=temp.next;
                cur=pre.next;
            }
            else{
                pre=cur;
                cur=cur.next;
            }
        }  
        return dummy.next; 
    }
}