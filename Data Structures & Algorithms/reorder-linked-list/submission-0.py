# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        if not head or not head.next:
            return
        
        slow, fast = head, head
        while fast.next and fast.next.next:
            slow = slow.next
            fast = fast.next.next
        
        second = slow.next
        slow.next = None

        prev, cur = None, second
        while cur:
            temp = cur.next
            cur.next = prev
            prev = cur
            cur = temp
        
        first, second = head, prev
        while second:
            first_next = first.next
            second_next = second.next
            first.next = second
            second.next = first_next

            first = first_next
            second = second_next
