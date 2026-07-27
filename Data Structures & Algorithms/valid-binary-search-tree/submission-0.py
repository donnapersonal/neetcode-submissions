# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.validate(root, None, None)
    
    def validate(self, root, min, max):
        if not root:
            return True
        
        if min and root.val <= min.val:
            return False
        
        if max and root.val >= max.val:
            return False
        
        return self.validate(root.left, min, root) and self.validate(root.right, root, max)
        