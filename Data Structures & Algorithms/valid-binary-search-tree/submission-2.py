# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         return self.validate(root, None, None)
    
#     def validate(self, root, min, max):
#         if not root:
#             return True
        
#         if min and root.val <= min.val:
#             return False
        
#         if max and root.val >= max.val:
#             return False
        
#         return self.validate(root.left, min, root) and self.validate(root.right, root, max)

# class Solution:
#     def isValidBST(self, root: Optional[TreeNode]) -> bool:
#         self.prev = float('-inf')
#         return self.validate(root)
    
#     def validate(self, root):
#         if not root:
#             return True

#         if not self.validate(root.left):
#             return False
        
#         if root.val <= self.prev:
#             return False

#         self.prev = root.val

#         return self.validate(root.right)

class Solution:
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        if not root:
            return True
        
        stack = []
        prev = None
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            
            cur = stack.pop()
            if prev and cur.val <= prev.val:
                return False
            
            prev = cur
            root = cur.right
        
        return True
