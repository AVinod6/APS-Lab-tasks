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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;

        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        while (count >= k) {
            curr = prev.next;
            ListNode nextGroupHead = curr;
            for (int i = 0; i < k - 1; i++) {
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = nextGroupHead;
            count -= k;
        }

        return dummy.next;
    }
}
