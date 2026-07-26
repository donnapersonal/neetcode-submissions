# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        low = min(p.val, q.val)
        high = max(p.val, q.val)
        cur = root
        while cur:
            if cur.val < low:
                cur = cur.right
            elif cur.val > high:
                cur = cur.left
            else:
                return cur
        
        return None