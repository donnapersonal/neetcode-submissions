# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def maxDepth(self, root: Optional[TreeNode]) -> int:
#         if not root:
#             return 0
        
#         que = collections.deque([root])
#         depth = 0

#         while que:
#             size = len(que)
#             for _ in range(size):
#                 cur = que.popleft()
#                 if cur.left:
#                     que.append(cur.left)
                
#                 if cur.right:
#                     que.append(cur.right)
                
#             depth += 1
        
#         return depth

# class Solution:
#     def maxDepth(self, root: Optional[TreeNode]) -> int:
#         if not root:
#             return 0
        
#         que = collections.deque([root])
#         depth = 0

#         while que:
#             size = len(que)
#             for _ in range(size):
#                 cur = que.popleft()
#                 if cur.left:
#                     que.append(cur.left)
                
#                 if cur.right:
#                     que.append(cur.right)
                
#             depth += 1
        
#         return depth

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        self.depth = 0;
        self.res = 0;
        self.traverse(root);
        return self.res
    
    def traverse(self, root):
        if not root:
            return
        
        self.depth += 1
        self.res = max(self.res, self.depth)
        self.traverse(root.left)
        self.traverse(root.right)
        self.depth -= 1






