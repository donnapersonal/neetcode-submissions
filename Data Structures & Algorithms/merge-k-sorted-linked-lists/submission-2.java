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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (node1, node2) -> Integer.compare(node1.val, node2.val)
        );
        for (ListNode head : lists) {
            if (head!= null) {
                minHeap.offer(head);
            }
        }

        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
            cur = cur.next;
        } 
        return dummy.next;
    }
}
