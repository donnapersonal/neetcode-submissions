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
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) return null;
//         ListNode dummy = new ListNode(-1);
//         ListNode cur = dummy;
//         PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
//             (node1, node2) -> Integer.compare(node1.val, node2.val)
//         );
//         for (ListNode head : lists) {
//             if (head!= null) {
//                 minHeap.offer(head);
//             }
//         }

//         while (!minHeap.isEmpty()) {
//             ListNode node = minHeap.poll();
//             cur.next = node;
//             if (node.next != null) {
//                 minHeap.offer(node.next);
//             }
//             cur = cur.next;
//         } 
//         return dummy.next;
//     }
// }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode leftNode = mergeSort(lists, left, mid);
        ListNode rightNode = mergeSort(lists, mid+1, right);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        }

        if (right != null) {
            cur.next = right;
        }

        return dummy.next;
    }
}
