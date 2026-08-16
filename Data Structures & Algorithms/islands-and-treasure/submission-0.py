class Solution:
    def islandsAndTreasure(self, grid: List[List[int]]) -> None:
        if not grid or not grid[0]:
            return
        
        m, n = len(grid), len(grid[0])
        INF = 2147483647
        TREASURE = 0
        que = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == TREASURE:
                    que.append((i, j))
        
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while que:
            x, y = que.popleft()
            for dx, dy in dirs:
                nx, ny = dx + x, dy + y
                if nx < 0 or nx >= m or ny < 0 or ny >= n or grid[nx][ny] != INF:
                    continue
                
                grid[nx][ny] = grid[x][y] + 1
                que.append((nx, ny))