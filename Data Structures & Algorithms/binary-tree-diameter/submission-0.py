# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        self.maxDiameter = 0
        self.getHeight(root)
        return self.maxDiameter
    
    def getHeight(self, root):
        if not root:
            return 0
        
        leftHeight = self.getHeight(root.left)
        rightHeight = self.getHeight(root.right)
        self.maxDiameter = max(self.maxDiameter, leftHeight + rightHeight)

        return max(leftHeight, rightHeight) + 1