# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
#         if not root:
#             return None
        
#         stack = [root]
#         while stack:
#             cur = stack.pop()
#             cur.left, cur.right = cur.right, cur.left
#             if cur.left:
#                 stack.append(cur.left)
            
#             if cur.right:
#                 stack.append(cur.right)
            
#         return root

class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        que = collections.deque([root])
        while que:
            size = len(que)
            for _ in range(size):
                cur = que.popleft()

                cur.left, cur.right = cur.right, cur.left
                if cur.left:
                    que.append(cur.left)
                
                if cur.right:
                    que.append(cur.right)
        return root