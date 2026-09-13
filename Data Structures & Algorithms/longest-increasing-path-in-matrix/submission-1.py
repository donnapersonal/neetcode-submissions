class Solution:
    def longestIncreasingPath(self, matrix: List[List[int]]) -> int:
        if not matrix or not matrix[0]:
            return 0
        
        m, n = len(matrix), len(matrix[0])
        memo = [[0] * n for _ in range(m)]
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]
        def dfs(i, j):
            if memo[i][j] != 0:
                return memo[i][j]
            
            max_len = 1
            for dx, dy in dirs:
                nx, ny = dx + i, dy + j
                if 0 <= nx < m and 0 <= ny < n and matrix[nx][ny] > matrix[i][j]:
                    max_len = max(max_len, 1 + dfs(nx, ny))
            
            memo[i][j] = max_len
            return max_len

        return max(dfs(i, j) for i in range(m) for j in range(n))