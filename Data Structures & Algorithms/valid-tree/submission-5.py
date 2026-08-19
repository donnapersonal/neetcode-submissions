class UF:
    def __init__(self, n: int):
        self.parent = [i for i in range(n)]
        self.size = [1] * n
    
    def find(self, x):
        while self.parent[x] != x:
            self.parent[x] = self.parent[self.parent[x]]
            x = self.parent[x]
        
        return x
    
    def union(self, x, y):
        rootX, rootY = self.find(x), self.find(y)
        if rootX == rootY:
            return False
        
        if self.size[rootX] < self.size[rootY]:
            rootX, rootY = rootY, rootX
        
        self.parent[rootY] = rootX
        self.size[rootX] += self.size[rootY]

        return True

class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False

        uf = UF(n)

        for u, v in edges:
            if not uf.union(u, v):
                return False

        return True
        