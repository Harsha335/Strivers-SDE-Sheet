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
    public ListNode reverse(ListNode head)
    {
        if(head==null || head.next==null)return head;
        ListNode pre=null,curr=head,nexty=head.next;
        while(nexty!=null)
        {
            curr.next=pre;
            pre=curr;
            curr=nexty;
            nexty=nexty.next;
        }
        curr.next=pre;
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur=head;
        for(int i=0;i<k-1;i++)
        {
            cur=cur.next;
            if(cur==null)return head;
        }
        // if(cur.next==null)return reverse(head);
        ListNode nexty=cur.next;
        ListNode last=head;
        cur.next=null;
        head=reverse(head);
        last.next=nexty;
        cur=last;
        // System.out.println(head.val+" "+head.next.val+" "+cur.val);
        while(cur!=null)
        {
            ListNode temp=cur;
            for(int i=0;i<k;i++)
            {
                temp=temp.next;
                if(temp==null)return head;
            }
            nexty=temp.next;
            last=cur.next;
            temp.next=null;
            cur.next=reverse(cur);
            last.next=nexty;
            cur=last;
        }
        return head;
    }
}