class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False
        self.word = None
    
class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert(self, word):
        node = self.root
        for ch in word:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            
            node = node.children[ch]
        
        node.isEnd = True
        node.word = word

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        for word in words:
            trie.insert(word)
        
        m, n = len(board), len(board[0])
        res = set()

        def dfs(row, col, node):
            ch = board[row][col]
            child = node.children.get(ch)
            if not child:
                return
            
            if child.isEnd:
                res.add(child.word)
            
            board[row][col] = "#"
            for dx, dy in [(-1, 0), (1, 0), (0, 1), (0, -1)]:
                nx, ny = dx + row, dy + col
                if 0 <= nx < m and 0 <= ny < n and board[nx][ny] != "#":
                    dfs(nx, ny, child)
            
            board[row][col] = ch
            
        for i in range(m):
            for j in range(n):
                if board[i][j] in trie.root.children:
                    dfs(i, j, trie.root)
        
        return list(res)