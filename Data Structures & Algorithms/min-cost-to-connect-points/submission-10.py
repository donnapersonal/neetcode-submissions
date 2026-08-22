# class UF:
#     def __init__(self, n):
#         self.parent = list(range(n))
#         self.rank = [1] * n
#         self.n = n
    
#     def find(self, x):
#         if self.parent[x] == x:
#             return x
        
#         self.parent[x] = self.find(self.parent[x])
#         return self.parent[x]
    
#     def union(self, x, y):
#         rootX, rootY = self.find(x), self.find(y)
#         if rootX == rootY:
#             return False
        
#         if self.rank[rootX] < self.rank[rootY]:
#             rootX, rootY = rootY, rootX
        
#         self.parent[rootY] = rootX
#         self.rank[rootX] += self.rank[rootY]
#         return True

# class Solution:
#     def minCostConnectPoints(self, points: List[List[int]]) -> int:
#         dist = lambda x, y: abs(points[x][0] - points[y][0]) + abs(points[x][1] - points[y][1])
#         n = len(points)
#         uf = UF(n)
#         edges = list()
#         for i in range(n):
#             for j in range(i+1, n):
#                 edges.append((dist(i, j), i, j))
        
#         edges.sort()
#         res = 0
#         num = 1
#         for length, x, y in edges:
#             if uf.union(x, y):
#                 res += length
#                 num += 1
#                 if num == n:
#                     break
        
#         return res

# class Solution:
#     def minCostConnectPoints(self, points: List[List[int]]) -> int:
#         return self.prim(points, 0)
    
#     def prim(self, points, start):
#         n = len(points)
#         res = 0
#         graph = [[0] * n for _ in range(n)]
#         for i in range(n):
#             for j in range(i+1, n):
#                 dist = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
#                 graph[i][j] = dist
#                 graph[j][i] = dist
            
#         lowcost = [float('inf')] * n
#         visited = [False] * n
#         visited[start] = True
        
#         for i in range(n):
#             if i != start:
#                 lowcost[i] = graph[i][start]
        
#         for i in range(1, n):
#             min_idx = -1
#             min_val = float('inf')
#             for j in range(n):
#                 if not visited[j] and lowcost[j] < min_val:
#                     min_idx = j
#                     min_val = lowcost[j]
                
#             visited[min_idx] = True
#             res += min_val
#             for j in range(n):
#                 if not visited[j] and graph[j][min_idx] < lowcost[j]:
#                     lowcost[j] = graph[j][min_idx]
        
#         return res

class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        n = len(points)
        min_dist = [float("inf")] * n
        min_dist[0] = 0
        visited = [False] * n
        res = 0

        for _ in range(n):
            cur = -1
            for i in range(n):
                if not visited[i] and (cur == -1 or min_dist[i] < min_dist[cur]):
                    cur = i
            
            visited[cur] = True
            res += min_dist[cur]
            for nxt in range(n):
                if not visited[nxt]:
                    dist = abs(points[cur][0] - points[nxt][0]) + abs(points[cur][1] - points[nxt][1])
                    min_dist[nxt] = min(min_dist[nxt], dist)
        
        return res