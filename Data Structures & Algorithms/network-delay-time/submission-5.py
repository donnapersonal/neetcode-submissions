# class Solution:
#     def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
#         graph = defaultdict(list)
#         for u, v, w in times:
#             graph[u].append((v, w))
        
#         min_heap = [(0, k)]
#         dist = {}
#         while min_heap:
#             cur_time, cur_node = heapq.heappop(min_heap)
#             if cur_node in dist:
#                 continue
            
#             dist[cur_node] = cur_time
#             for nei, w in graph[cur_node]:
#                 if nei not in dist:
#                     heapq.heappush(min_heap, (cur_time + w, nei))
        
#         return max(dist.values()) if len(dist) == n else -1

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = [[] for _ in range(n+1)]
        for u, v, w in times:
            graph[u].append((v, w))
        
        min_heap = [(0, k)]
        dist = [float("inf")] * (n + 1)
        dist[k] = 0

        while min_heap:
            cur_time, cur_node = heapq.heappop(min_heap)
            if cur_time > dist[cur_node]:
                continue
            
            for nei, w in graph[cur_node]:
                new_time = w + cur_time
                if new_time < dist[nei]:
                    dist[nei] = new_time
                    heapq.heappush(min_heap, (new_time, nei))
        
        res = max(dist[1:])
        if res == float('inf'):
            return -1
        
        return res