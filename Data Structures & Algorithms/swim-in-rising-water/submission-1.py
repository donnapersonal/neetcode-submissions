class Solution:
    def swimInWater(self, grid: List[List[int]]) -> int:
        n = len(grid)
        dist = [[float("inf")] * n for _ in range(n)]
        dist[0][0] = grid[0][0]
        heap = [(grid[0][0], 0, 0)]
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while heap:
            time, r, c = heapq.heappop(heap)
            if time > dist[r][c]:
                continue
            
            if (r, c) == (n-1, n-1):
                return time
            
            for dr, dc in dirs:
                nr, nc = dr + r, dc + c
                if 0 <= nr < n and 0 <= nc < n:
                    newTime = max(time, grid[nr][nc])
                    if newTime < dist[nr][nc]:
                        dist[nr][nc] = newTime
                        heapq.heappush(heap, (newTime, nr, nc))
        
        return -1