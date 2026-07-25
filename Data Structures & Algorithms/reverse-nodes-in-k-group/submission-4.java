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
//     public ListNode reverseKGroup(ListNode head, int k) {
//         if (head == null) return null;
//         ListNode a = head, b = head;
//         for (int i = 0; i < k; i++) {
//             if (b == null) {
//                 return head;
//             }
//             b = b.next;
//         }

//         ListNode newHead = reverse(a, b);
//         a.next = reverseKGroup(b, k);
//         return newHead;
//     }

//     private ListNode reverse(ListNode a, ListNode b) {
//         ListNode prev = null, cur = a;
//         while (cur != b) {
//             ListNode next = cur.next;
//             cur.next = prev;
//             prev = cur;
//             cur = next;
//         }
//         return prev;
//     }
// }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        
        while (count >= k) {
            ListNode cur = p.next;
            ListNode next = cur;

            for (int i = 0; i < k; i++) {
                next = next.next;
            }

            p.next = reverseLinkedList(cur, k);
            cur.next = next;
            p = cur;
            count -= k;
        }
        return dummy.next;
    }

    private ListNode reverseLinkedList(ListNode head, int k) {
        ListNode prev = null, cur = head;
        while (k > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k -= 1;
        }
        return prev;
    }
}
