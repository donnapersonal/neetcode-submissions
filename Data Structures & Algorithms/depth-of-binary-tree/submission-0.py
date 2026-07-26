# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        que = collections.deque([root])
        depth = 0

        while que:
            size = len(que)
            for _ in range(size):
                cur = que.popleft()
                if cur.left:
                    que.append(cur.left)
                
                if cur.right:
                    que.append(cur.right)
                
            depth += 1
        
        return depth
