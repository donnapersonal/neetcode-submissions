# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        return self.getHight(root) != -1
    
    def getHight(self, root):
        if not root:
            return 0
        
        leftHeight = self.getHight(root.left)
        rightHeight = self.getHight(root.right)
        if leftHeight == -1 or rightHeight == -1:
            return -1
        
        if abs(leftHeight - rightHeight) > 1:
            return -1
        
        return max(leftHeight, rightHeight) + 1