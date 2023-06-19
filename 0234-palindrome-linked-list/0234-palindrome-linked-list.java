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
    ListNode reverse(ListNode head)
    {
        ListNode pre=null,cur=head,nexty=cur.next;
        while(nexty!=null)
        {
            cur.next=pre;
            pre=cur;
            cur=nexty;
            nexty=nexty.next;
        }
        cur.next=pre;
        return cur;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)return true;
        // if(head.next.next==null)
        // {
        //     if(head.val==head.next.val)return true;
        //     return false;
        // }
        ListNode slow=head;
        ListNode fast=head.next.next;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode head2=slow.next;
        slow.next=null;
        if(fast!=null && fast.next==null)//ODD
        {
            head2=head2.next;
        }
        head2=reverse(head2);
        while(head!=null && head2!=null)
        {
            if(head.val!=head2.val)return false;
            head=head.next;
            head2=head2.next;
        }
        if(head==null && head2==null)return true;
        return false;
    }
}