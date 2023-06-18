/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode cur1=headA;
        ListNode cur2=headB;
        while(cur1!=null)
        {
            cur1.val=-cur1.val;
            cur1=cur1.next;
        }
        ListNode ans=null;
        while(cur2!=null)
        {
            if(cur2.val<0)
            {
                ans=cur2;
                break;
            }
            cur2=cur2.next;
        }
        cur1=headA;
        while(cur1!=null)
        {
            cur1.val=-cur1.val;
            cur1=cur1.next;
        }
        return ans;
    }
}