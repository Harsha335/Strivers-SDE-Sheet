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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output=new ListNode(-1);
        ListNode cur=output;
        int carry=0;
        while(l1!=null && l2!=null)
        {
            int data=l1.val+l2.val+carry;
            cur.next=new ListNode(data%10);
            carry=data/10;
            l1=l1.next;
            l2=l2.next;
            cur=cur.next;
        }
        while(l1!=null)
        {
            int data=l1.val+carry;
            cur.next=new ListNode(data%10);
            carry=data/10;
            l1=l1.next;
            cur=cur.next;
        }
        while(l2!=null)
        {
            int data=l2.val+carry;
            cur.next=new ListNode(data%10);
            carry=data/10;
            l2=l2.next;
            cur=cur.next;
        }
        cur.next=carry==1?new ListNode(1):null;
        return output.next;
    }
}