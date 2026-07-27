# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        self.max_sum = float('-inf');
        self.dfs(root)
        return self.max_sum
    
    def dfs(self, root):
        if not root:
            return 0
        
        left_sum = max(self.dfs(root.left), 0)
        right_sum = max(self.dfs(root.right), 0)
        priceNewpath = root.val + left_sum + right_sum
        self.max_sum = max(priceNewpath, self.max_sum)
        return root.val + max(left_sum, right_sum)
