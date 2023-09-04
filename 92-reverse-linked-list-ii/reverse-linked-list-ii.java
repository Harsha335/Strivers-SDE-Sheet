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
    ListNode reverse(ListNode pre1,ListNode pre2,ListNode next2)
    {
        ListNode temp=pre1.next;
        ListNode nexty=temp.next;
        ListNode pre=next2;
        pre1.next=null;
        pre2.next=null;
        while(nexty!=null)
        {
            // System.out.println(pre.val+" "+temp.val+" "+nexty.val);
            temp.next=pre;
            pre=temp;
            temp=nexty;
            nexty=nexty.next;
        }
            // System.out.println(pre.val+" "+temp.val+" "+nexty);
        // System.out.println(temp.val);
        temp.next=pre;
        return temp;
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right)
            return head;
        ListNode demo=new ListNode();
        demo.next=head;
        ListNode curr=demo;
        ListNode pre1=demo;
        int count=0;
        while(curr!=null && count!=left)
        {
            pre1=curr;
            curr=curr.next;
            count++;
        }
        
        ListNode pre2=curr;
        while(curr!=null && count!=right)
        {
            // pre2=curr;
            curr=curr.next;
            count++;
        }
        pre2=curr;
        curr=curr.next;
        // System.out.println(pre1.val+" "+pre2.val);
        
        pre1.next=reverse(pre1,pre2,curr);
        // temp.next=pre1;
        return demo.next;
    }
}