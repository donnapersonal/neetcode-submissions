class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        res = []
        board = [['.' for _ in range(n)] for _ in range(n)]
        def dfs(row):
            if row == n:
                res.append(["".join(row) for row in board])
                return
            
            for col in range(len(board[row])):
                if not self.isValid(board, row, col):
                    continue
                
                board[row][col] = 'Q'
                dfs(row+1)
                board[row][col] = '.'

        dfs(0)
        return res
    
    def isValid(self, board, row, col):
        n = len(board)
        for i in range(row+1):
            if board[i][col] == 'Q':
                return False
        
        for i, j in zip(range(row-1, -1, -1), range(col+1, n)):
            if board[i][j] == 'Q':
                return False
        
        for i, j in zip(range(row-1, -1, -1), range(col-1, -1, -1)):
            if board[i][j] == 'Q':
                return False
        
        return True
