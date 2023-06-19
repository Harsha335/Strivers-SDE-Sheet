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
    int getLength(ListNode head)
    {
        int length=0;
        while(head!=null)
        {
            length++;
            head=head.next;
        }
        return length;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null|| head.next==null)return head;
        int length=getLength(head);
        k=k%length;
        if(k==0)return head;
        // System.out.println(length+" "+k+" "+head.val);
        //get last k elements
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<k;i++)
        {
            fast=fast.next;
        }
        while(fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        ListNode headNew=slow.next;
        slow.next=null;
        fast.next=head;
        return headNew;
    }
}