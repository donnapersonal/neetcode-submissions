# class Solution:
#     def solve(self, board: List[List[str]]) -> None:
#         if not board:
#             return
        
#         m, n = len(board), len(board[0])

#         def dfs(r, c):
#             if not 0 <= r < m or not 0 <= c < n or board[r][c] != 'O':
#                 return
            
#             board[r][c] = 'A'
#             dfs(r+1, c)
#             dfs(r-1, c)
#             dfs(r, c+1)
#             dfs(r, c-1)

#         for i in range(m):
#             dfs(i, 0)
#             dfs(i, n-1)

#         for i in range(n):
#             dfs(0, i)
#             dfs(m-1, i)

#         for i in range(m):
#             for j in range(n):
#                 if board[i][j] == 'A':
#                     board[i][j] = 'O'
#                 elif board[i][j] == 'O':
#                     board[i][j] = 'X'

class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if not board or not board[0]:
            return
        
        m, n = len(board), len(board[0])
        que = deque()


        def make_boarder(r, c):
            if board[r][c] == 'O':
                board[r][c] = 'A'
                que.append((r, c))

        for i in range(m):
            make_boarder(i, 0)
            make_boarder(i, n-1)

        for i in range(n):
            make_boarder(0, i)
            make_boarder(m-1, i)

        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while que:
            r, c = que.popleft()
            for dr, dc in dirs:
                nr, nc = dr + r, dc + c
                if 0 <= nr < m and 0 <= nc < n and board[nr][nc] == 'O':
                    board[nr][nc] = 'A'
                    que.append((nr, nc))

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'A':
                    board[i][j] = 'O'
                elif board[i][j] == 'O':
                    board[i][j] = 'X'