class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        parent = [i for i in range(n+1)]
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])

            return parent[x]
        
        def union(x, y):
            rootX = find(x)
            rootY = find(y)
            if rootX == rootY:
                return False 
            
            parent[rootX] = rootY 
            return True
        
        for u, v in edges:
            if not union(u, v):
                return [u, v]
        
        return []