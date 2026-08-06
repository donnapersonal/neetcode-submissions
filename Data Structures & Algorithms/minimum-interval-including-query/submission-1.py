class Solution:
    def minInterval(self, intervals: List[List[int]], queries: List[int]) -> List[int]:
        n, m = len(intervals), len(queries)
        intervals.sort(key=lambda x:x[0])
        sorted_queries = sorted((query, index) for index, query in enumerate(queries));
        pq = []
        res = [-1] * m
        index = 0
        for query, original_idx in sorted_queries:
            while index < n and intervals[index][0] <= query:
                left, right = intervals[index]
                heapq.heappush(pq, (right - left + 1, right))
                index += 1
            
            while pq and pq[0][1] < query:
                heapq.heappop(pq)
            
            if pq:
                res[original_idx] = pq[0][0]
        
        return res