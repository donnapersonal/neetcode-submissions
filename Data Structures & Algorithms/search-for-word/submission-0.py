class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or not board[0]:
            return False
        
        rows, cols = len(board), len(board[0])
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        def dfs(r, c, index):
            if index == len(word):
                return True
            
            if r < 0 or c < 0 or r >= rows or c >= cols or board[r][c] != word[index]:
                return False
            
            temp = board[r][c]
            board[r][c] = '#'
            for dx, dy in dirs:
                if dfs(r+dx, c+dy, index+1):
                    return True
            
            board[r][c] = temp
            return False
            
        for i in range(rows):
            for j in range(cols):
                if dfs(i, j, 0):
                    return True
        
        return False