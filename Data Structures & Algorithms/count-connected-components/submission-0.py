class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        parent = list(range(n))
        rank = [0] * n
        count = n
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            
            return parent[x]
        
        def union(x, y):
            nonlocal count
            rootX = find(x)
            rootY = find(y)
            if rootX == rootY:
                return 
            
            if rank[rootX] < rank[rootY]:
                rootX, rootY = rootY, rootX
            
            parent[rootY] = rootX
            rank[rootX] += rank[rootY]
            count -= 1
        
        for u, v in edges:
            union(u, v)
        
        return count