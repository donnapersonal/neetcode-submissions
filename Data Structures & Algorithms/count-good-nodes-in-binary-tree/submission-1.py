# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def goodNodes(self, root: TreeNode) -> int:
#         return dfs(root, -10**9)
    
#     def dfs(self, root, max_val):
#         if not root:
#             return 0
        
#         res = 0
#         if root.val >= max_val:
#             res += 1
#             max_val = root.val
        
#         res += self.dfs(root.left, max_val) + self.dfs(root.right, max_val)
#         return res

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        return self.dfs(root, root.val)
    
    def dfs(self, root, max_val):
        if not root:
            return 0
        cur_count = 1 if root.val >= max_val else 0
        new_max = max(max_val, root.val)
        
        return cur_count + self.dfs(root.left, new_max) + self.dfs(root.right, new_max)