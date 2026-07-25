"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

# class Solution:
#     def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
#         originToClone = {}
#         p = head
#         while p:
#             if p not in originToClone:
#                 originToClone[p] = Node(p.val)
            
#             p = p.next
        
#         p = head
#         while p:
#             if p.next:
#                 originToClone[p].next = originToClone[p.next]
            
#             if p.random:
#                 originToClone[p].random = originToClone[p.random]
            
#             p = p.next
        
#         return originToClone.get(head)

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head:
            return None
        
        cur = head
        while cur:
            clone = Node(cur.val)
            clone.next = cur.next
            cur.next = clone
            cur = clone.next
        
        cur = head
        while cur:
            if cur.random:
                cur.next.random = cur.random.next
            
            cur = cur.next.next
        
        cur = head
        clone_head = head.next
        while cur:
            clone = cur.next
            cur.next = clone.next
            cur = cur.next
            if cur:
                clone.next = cur.next
        
        return clone_head
