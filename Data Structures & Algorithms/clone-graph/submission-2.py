"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

# class Solution:
#     def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
#         if not node:
#             return node
        
#         visited = dict()
#         def dfs(node):
#             if node in visited:
#                 return visited[node]
            
#             cloned = Node(node.val)
#             visited[node] = cloned
#             for nei in node.neighbors:
#                 cloned.neighbors.append(dfs(nei))
#             return cloned

#         return dfs(node)

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return node
        
        visited = dict()
        visited[node] = Node(node.val)
        que = deque([node])

        while que:
            cur = que.popleft()
            for nei in cur.neighbors:
                if nei not in visited:
                    visited[nei] = Node(nei.val)
                    que.append(nei)
                
                visited[cur].neighbors.append(visited[nei])
        
        return visited[node]
        