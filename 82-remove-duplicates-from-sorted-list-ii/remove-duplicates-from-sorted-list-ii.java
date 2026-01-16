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
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node before head to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;   // last node before duplicates
        ListNode curr = head;

        while (curr != null) {
            // Detect duplicates
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }

            // If prev.next != curr, duplicates were found
            if (prev.next != curr) {
                prev.next = curr.next; // remove all duplicates
            } else {
                prev = prev.next; // move prev normally
            }

            curr = curr.next;
        }
        return dummy.next;
    }
}
