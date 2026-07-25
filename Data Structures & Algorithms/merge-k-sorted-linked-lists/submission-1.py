# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# class Solution:    
#     def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
#         if not lists:
#             return None
        
#         dummy = ListNode(-1)
#         cur = dummy
#         pq = []
#         for head in lists:
#             if head:
#                 heapq.heappush(pq, (head.val, id(head), head))
        
#         while pq:
#             node = heapq.heappop(pq)[2]
#             cur.next = node

#             if node.next:
#                 heapq.heappush(pq, (node.next.val, id(node.next), node.next))
            
#             cur = cur.next
        
#         return dummy.next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists:
            return None
        
        return self.mergeSort(lists, 0, len(lists) - 1)
    
    def mergeSort(self, lists, left, right):
        if left == right:
            return lists[left]
        
        mid = left + (right - left) // 2
        leftNode = self.mergeSort(lists, left, mid)
        rightNode = self.mergeSort(lists, mid+1, right)
        return self.merge(leftNode, rightNode)
    
    def merge(self, left, right):
        dummy = ListNode(-1)
        cur = dummy
        while left and right:
            if left.val < right.val:
                cur.next = left
                left = left.next
            else:
                cur.next = right
                right = right.next
            
            cur = cur.next
        
        if left:
            cur.next = left

        if right:
            cur.next = right
        
        return dummy.next
