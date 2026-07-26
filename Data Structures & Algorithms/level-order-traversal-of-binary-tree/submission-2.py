# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        res = []
        if not root:
            return []
        
        que = collections.deque([root])
        while que:
            size = len(que)
            level_node = []
            for i in range(size):
                cur = que.popleft()
                level_node.append(cur.val)
                if cur.left:
                    que.append(cur.left)
                
                if cur.right:
                    que.append(cur.right)
            
            res.append(level_node)
        
        return res