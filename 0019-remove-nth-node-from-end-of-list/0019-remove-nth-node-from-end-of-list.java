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
    public ListNode removeNthFromEnd(ListNode head, int k) {
        ListNode slow=head,fast=head;
        ListNode pre=null;
        while(k-->0 && fast!=null)
        {
            fast=fast.next;
        }
        while(fast!=null)
        {
            pre=slow;
            slow=slow.next;
            fast=fast.next;
        }
        if(pre==null)return head.next;
        pre.next=slow.next;
        return head;
    }
}