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
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) return head;
//         ListNode prev = null;
//         ListNode cur = head;
//         ListNode temp = null;
//         while (cur != null) {
//             temp = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = temp;
//         }
//         return prev;
//     }
// }

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         return reverse(null, head);
//     }

//     private ListNode reverse(ListNode prev, ListNode cur) {
//         if (cur == null) return prev;
//         ListNode next = cur.next;
//         cur.next = prev;
//         return reverse(cur, next);
//     }
// }

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
