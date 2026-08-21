class UF:
    def __init__(self, n):
        self.parent = list(range(n))
        self.rank = [1] * n
        self.n = n
    
    def find(self, x):
        if self.parent[x] == x:
            return x
        
        self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def union(self, x, y):
        rootX, rootY = self.find(x), self.find(y)
        if rootX == rootY:
            return False
        
        if self.rank[rootX] < self.rank[rootY]:
            rootX, rootY = rootY, rootX
        
        self.parent[rootY] = rootX
        self.rank[rootX] += self.rank[rootY]
        return True

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        dist = lambda x, y: abs(points[x][0] - points[y][0]) + abs(points[x][1] - points[y][1])
        n = len(points)
        uf = UF(n)
        edges = list()
        for i in range(n):
            for j in range(i+1, n):
                edges.append((dist(i, j), i, j))
        
        edges.sort()
        res = 0
        num = 1
        for length, x, y in edges:
            if uf.union(x, y):
                res += length
                num += 1
                if num == n:
                    break
        
        return res


