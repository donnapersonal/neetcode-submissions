# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# class Codec:
    
#     # Encodes a tree to a single string.
#     def serialize(self, root: Optional[TreeNode]) -> str:
#         if not root:
#             return 'None'
        
#         return str(root.val) + ',' + self.serialize(root.left) + ',' + self.serialize(root.right)
        
#     # Decodes your encoded data to tree.
#     def deserialize(self, data: str) -> Optional[TreeNode]:
#         dataList = data.split(',')
#         self.index = 0
#         def dfs():
#             cur = dataList[self.index]
#             self.index += 1
#             if cur == 'None':
#                 return None
            
#             root = TreeNode(int(cur))
#             root.left = dfs()
#             root.right = dfs()
#             return root

#         return dfs()

# class Codec:
#     def __init__(self):
#         self.SEP = ","
#         self.NULL = "#"

#     # Encodes a tree to a single string.
#     def serialize(self, root: Optional[TreeNode]) -> str:
#         values = []
#         def dfs(node: Optional["TreeNode"]) -> None:
#             if node is None:
#                 values.append(self.NULL)
#                 return
            
#             values.append(str(node.val))
#             dfs(node.left)
#             dfs(node.right)

#         dfs(root)
#         return self.SEP.join(values)

#     # Decodes your encoded data to tree.
#     def deserialize(self, data: str) -> Optional[TreeNode]:
#         values = data.split(self.SEP)
#         self.index = 0

#         def dfs() -> Optional["TreeNode"]:
#             cur = values[self.index]
#             self.index += 1

#             if cur == self.NULL:
#                 return None

#             node = TreeNode(int(cur))
#             node.left = dfs()
#             node.right = dfs()

#             return node

#         return dfs()

class Codec:
    def __init__(self):
        self.SEP = ","
        self.NULL = "#"

    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return ""
        
        res = []
        que = deque([root])
        while que:
            node = que.popleft()
            if node:
                res.append(str(node.val))
                que.append(node.left)
                que.append(node.right)
            else:
                res.append(self.NULL)
        
        return self.SEP.join(res)

    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        if not data:
            return None
        
        nodes = data.split(self.SEP)
        root = TreeNode(int(nodes[0]))
        que = deque([root])
        index = 1

        while que:
            parent = que.popleft()

            left_val = nodes[index]
            index += 1
            if left_val != self.NULL: 
                parent.left = TreeNode(int(left_val))
                que.append(parent.left)
            
            right_val = nodes[index]
            index += 1
            if right_val != self.NULL:  
                parent.right = TreeNode(int(right_val))
                que.append(parent.right)
            
        return root


