"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        originToClone = {}
        p = head
        while p:
            if p not in originToClone:
                originToClone[p] = Node(p.val)
            
            p = p.next
        
        p = head
        while p:
            if p.next:
                originToClone[p].next = originToClone[p.next]
            
            if p.random:
                originToClone[p].random = originToClone[p.random]
            
            p = p.next
        
        return originToClone.get(head)