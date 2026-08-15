# class Solution:
#     def solveNQueens(self, n: int) -> List[List[str]]:
#         res = []
#         board = [['.' for _ in range(n)] for _ in range(n)]
#         def dfs(row):
#             if row == n:
#                 res.append(["".join(row) for row in board])
#                 return
            
#             for col in range(len(board[row])):
#                 if not self.isValid(board, row, col):
#                     continue
                
#                 board[row][col] = 'Q'
#                 dfs(row+1)
#                 board[row][col] = '.'

#         dfs(0)
#         return res
    
#     def isValid(self, board, row, col):
#         n = len(board)
#         for i in range(row+1):
#             if board[i][col] == 'Q':
#                 return False
        
#         for i, j in zip(range(row-1, -1, -1), range(col+1, n)):
#             if board[i][j] == 'Q':
#                 return False
        
#         for i, j in zip(range(row-1, -1, -1), range(col-1, -1, -1)):
#             if board[i][j] == 'Q':
#                 return False
        
#         return True

class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        queens = [0] * n
        col = [False] * n
        diag1 = [False] * (n * 2 - 1)
        diag2 = [False] * (n * 2 - 1)
        def dfs(r):
            if r == n:
                res.append(['.' * c + 'Q' + '.' * (n - 1 - c) for c in queens])
                return

            for c, ok in enumerate(col):
                if not ok and not diag1[r + c] and not diag2[r - c]: 
                    queens[r] = c 
                    col[c] = diag1[r+c] = diag2[r-c] = True
                    dfs(r+1)
                    col[c] = diag1[r+c] = diag2[r-c] = False
        dfs(0)
        return res
