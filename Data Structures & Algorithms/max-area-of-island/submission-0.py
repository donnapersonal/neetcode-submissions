# class Solution:
#     def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
#         m, n = len(grid), len(grid[0])
#         max_area = 0 
#         dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
#         for i in range(m):
#             for j in range(n):
#                 if grid[i][j] == 1:
#                     que = deque([(i, j)])
#                     area = 1
#                     grid[i][j] = 0

#                     while que:
#                         x, y = que.popleft()
#                         for dx, dy in dirs:
#                             nx, ny = x + dx, y + dy
#                             if (0 <= nx < m and 0 <= ny < n and grid[nx][ny] == 1):
#                                 grid[nx][ny] = 0
#                                 que.append((nx, ny))
#                                 area += 1
                    
#                     max_area = max(max_area, area)
        
#         return max_area

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        max_area = 0 
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    stack = [(i, j)]
                    area = 0
                    grid[i][j] = 0

                    while stack:
                        x, y = stack.pop()
                        area += 1
                        for dx, dy in dirs:
                            nx, ny = x + dx, y + dy
                            if (0 <= nx < m and 0 <= ny < n and grid[nx][ny] == 1):
                                grid[nx][ny] = 0
                                stack.append((nx, ny))
                    
                    max_area = max(max_area, area)
        
        return max_area
