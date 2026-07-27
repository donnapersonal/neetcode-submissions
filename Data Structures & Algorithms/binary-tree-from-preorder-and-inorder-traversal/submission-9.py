# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Solution:
#     def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
#         self.valToIndex = {}
#         for i in range(len(inorder)):
#             self.valToIndex[inorder[i]] = i
        
#         return self.build(preorder, 0, len(preorder)-1, 0, len(inorder)-1)
    
#     def build(self, preorder, preStart, preEnd, inStart, inEnd):
#         if preStart > preEnd or inStart > inEnd:
#             return None
        
#         rootVal = preorder[preStart]
#         rootIndex = self.valToIndex[rootVal]
#         leftSize = rootIndex - inStart
#         root = TreeNode(rootVal)
        
#         root.left = self.build(preorder, preStart+1, preStart+leftSize, inStart, rootIndex - 1)
#         root.right = self.build(preorder, preStart+leftSize+1, preEnd, rootIndex+1, inEnd)

#         return root

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        if not preorder:
            return None
        
        root = TreeNode(preorder[0])
        stack = [root]
        inorderIndex = 0
        for i in range(1, len(preorder)):
            preorderVal = preorder[i]
            node = stack[-1]
            if node.val != inorder[inorderIndex]:
                node.left = TreeNode(preorderVal)
                stack.append(node.left)
            else:
                while stack and stack[-1].val == inorder[inorderIndex]:
                    node = stack.pop()
                    inorderIndex += 1
                
                node.right = TreeNode(preorderVal)
                stack.append(node.right)
            
        return root

