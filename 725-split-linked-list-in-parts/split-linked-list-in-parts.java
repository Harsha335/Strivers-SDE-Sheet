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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len=0;
        ListNode temp=head;
        while(temp!=null)
        {
            temp=temp.next;
            len++;
        }
        int times=len/k;
        int extra=len%k;
        int curr=times+((extra>0)?1:0);
        extra-=1;
        ListNode[] output=new ListNode[k];
        temp=head;
        ListNode head1=temp;
        ListNode pre=null;
        int ind=0;
        while(temp!=null)
        {
            if(curr==0)
            {
                pre.next=null;
                output[ind++]=head1;
                head1=temp;
                curr=times+((extra>0)?1:0);
                extra-=1;
            }
            curr-=1;
            pre=temp;
            temp=temp.next;
        }
        output[ind++]=head1;
        return output;
    }
}