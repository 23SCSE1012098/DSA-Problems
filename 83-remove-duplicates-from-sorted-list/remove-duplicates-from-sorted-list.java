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
// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         if(head == null || head.next==null){
//             return head;
//         }
//         ListNode dummy = new ListNode (head.val);
//         ListNode ans = dummy;
//         ListNode curr = dummy.next;
//         while(curr != null){
//             if(curr.val == dummy.val){
//                 dummy.next = curr.next;
//             }
//             else{
//                 dummy=dummy.next;
//                 curr= curr.next;

//             }
            
//         }
//         return ans;
        
//     }
// }

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                // skip duplicate
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}