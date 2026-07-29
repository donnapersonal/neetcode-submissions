class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
    String word = null;
}

class Trie {
    TrieNode root = new TrieNode();
    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
        node.word = word;
    }
}

class Solution {
    private Set<String> res = new HashSet<>();
    private int m;
    private int n;
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for (String word : words) {
            trie.insert(word);
        }

        m = board.length;
        n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (trie.root.children.containsKey(board[row][col])) {
                    dfs(board, row, col, trie.root);
                }
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int row, int col, TrieNode root) {
        char ch = board[row][col];
        TrieNode child = root.children.get(ch);

        if (child == null) {
            return;
        }

        if (child.isEnd) {
            res.add(child.word);
        }

        board[row][col] = '#';

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] dir : dirs) {
            int nx = row + dir[0];
            int ny = col + dir[1];

            if (
                nx >= 0 && nx < m &&
                ny >= 0 && ny < n &&
                board[nx][ny] != '#'
            ) {
                dfs(board, nx, ny, child);
            }
        }

        board[row][col] = ch;
    }
}
