# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# class Solution:
#     def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
#         if not head or not head.next:
#             return head
        
#         prev, cur, temp = None, head, None

#         while cur:
#             temp = cur.next
#             cur.next = prev
#             prev = cur
#             cur = temp
        
#         return prev

# class Solution:
#     def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
#         return self.reverse(None, head)
    
#     def reverse(self, prev, cur):
#         if not cur:
#             return prev
        
#         nxt = cur.next
#         cur.next = prev

#         return self.reverse(cur, nxt)

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        new_head = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return new_head