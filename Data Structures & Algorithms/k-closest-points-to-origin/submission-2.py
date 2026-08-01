# class Solution:
#     def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
#         pq = []
#         for x, y in points:
#             dist = -(x * x + y * y)
#             if len(pq) < k:
#                 heapq.heappush(pq, (dist, [x, y]))
#             else:
#                 if dist > pq[0][0]:
#                     heapq.heapreplace(pq, (dist, [x, y]))
        
#         return [point for (dist, point) in pq]

class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        pq = []
        for x, y in points:
            dist = -(x * x + y * y)
            heapq.heappush(pq, (dist, x, y))
            if len(pq) > k:
                heapq.heappop(pq)
        
        return [[x, y] for _, x, y in pq]