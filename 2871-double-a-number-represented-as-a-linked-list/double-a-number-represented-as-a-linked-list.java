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
import java.math.*;
class Solution {
    ListNode reverse(ListNode head)
    {
        ListNode cur=head,pre=null,nex=cur.next;
        while(nex!=null)
        {
            cur.next=pre;
            pre=cur;
            cur=nex;
            nex=nex.next;
        }
        // System.out.println(cur.val+" ;");
        cur.next=pre;
        return cur;
    }
    public ListNode doubleIt(ListNode head) {
        head=reverse(head);
        ListNode temp=head;
        int carry=0;
        ListNode tail=null;
        while(temp!=null)
        {
            int num=temp.val*2;
            temp.val=(num+carry)%10;
            if((num+carry)>=10) carry=1;
            else carry=0;
            tail=temp;
            // System.out.println(temp.val);
            temp=temp.next;
        }
        if(carry!=0)
        {
            // System.out.println(carry);
            tail.next=new ListNode(carry);
        }
        return reverse(head);
    }
}