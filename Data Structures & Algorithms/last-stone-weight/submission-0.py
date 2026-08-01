class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        pq = []
        for stone in stones:
            heapq.heappush(pq, -stone)
        
        while len(pq) > 1:
            x, y = heapq.heappop(pq), heapq.heappop(pq)
            if x != y:
                heapq.heappush(pq, x-y)
            
        return 0 if len(pq) == 0 else -pq[0]