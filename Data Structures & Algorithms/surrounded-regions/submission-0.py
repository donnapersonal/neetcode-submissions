class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if not board:
            return
        
        m, n = len(board), len(board[0])

        def dfs(r, c):
            if not 0 <= r < m or not 0 <= c < n or board[r][c] != 'O':
                return
            
            board[r][c] = 'A'
            dfs(r+1, c)
            dfs(r-1, c)
            dfs(r, c+1)
            dfs(r, c-1)

        for i in range(m):
            dfs(i, 0)
            dfs(i, n-1)

        for i in range(n):
            dfs(0, i)
            dfs(m-1, i)

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'A':
                    board[i][j] = 'O'
                elif board[i][j] == 'O':
                    board[i][j] = 'X'