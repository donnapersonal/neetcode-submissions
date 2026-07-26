# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
#         self.res = []
#         self.traverse(root, 0)
#         return self.res
    
#     def traverse(self, root, depth):
#         if not root:
#             return
        
#         if len(self.res) == depth:
#             self.res.append(root.val)
        
#         self.traverse(root.right, depth+1)
#         self.traverse(root.left, depth+1)

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        res = []
        if not root:
            return res
        
        que = collections.deque([root])
        while que:
            size = len(que)
            last = que[0]
            for _ in range(size):
                cur = que.popleft()
                if cur.right:
                    que.append(cur.right)

                if cur.left:
                    que.append(cur.left)

            res.append(last.val)

        return res        
