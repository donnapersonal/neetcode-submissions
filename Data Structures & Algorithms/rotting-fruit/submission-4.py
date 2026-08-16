class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        if not grid:
            return -1
        
        m, n = len(grid), len(grid[0])
        fresh = 0
        minutes = 0
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        que = deque()
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    que.append((i, j))
                elif grid[i][j] == 1:
                    fresh += 1
        
        if fresh == 0:
            return 0
        
        while que and fresh > 0:
            minutes += 1
            size = len(que)
            for _ in range(size):
                x, y = que.popleft()
                for dx, dy in dirs:
                    nx, ny = dx + x, dy + y
                    if 0 <= nx < m and 0 <= ny < n and grid[nx][ny] == 1:
                        fresh -= 1
                        grid[nx][ny] = 2
                        que.append((nx, ny))
        
        return minutes if fresh == 0 else -1