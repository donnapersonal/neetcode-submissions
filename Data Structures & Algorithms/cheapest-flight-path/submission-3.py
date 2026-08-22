# class Solution:
#     def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
#         prices = [float("inf")] * n
#         prices[src] = 0

#         for i in range(k+1):
#             tmp = prices[:]
#             for u, v, w in flights:
#                 if prices[u] != float("inf"):
#                     tmp[v] = min(tmp[v], prices[u] + w)
            
#             prices = tmp
        
#         if prices[dst] == float("inf"):
#             return -1
        
#         return prices[dst]

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for u, v, w in flights:
            graph[u].append((v, w))
        
        visited = {}
        min_heap = [(0, 0, src)]
        while min_heap:
            cost, stops, node = heapq.heappop(min_heap)
            if node == dst:
                return cost
            
            if stops > k:
                continue
            
            if (node, stops) in visited and visited[(node, stops)] <= cost:
                continue
            
            visited[(node, stops)] = cost

            for nei, price in graph[node]:
                next_cost = price + cost
                heapq.heappush(min_heap, (next_cost, stops+1, nei))
            
        return -1
            
        