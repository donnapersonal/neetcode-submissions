class Solution {
    private int rows;
    private int cols;
    private char[][] board;
    private String word;
    private int[][] dirs = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        this.rows = board.length;
        this.cols = board[0].length;
        this.word = word;
        this.board = board;

        if (word.length() > rows * cols) return false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r, int c, int index) {
        if (index == word.length()) return true;
        if (
            r < 0 || r >= rows ||
            c < 0 || c >= cols ||
            board[r][c] != word.charAt(index)
        ) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        for (int[] dir : dirs) {
            int nextRow = r + dir[0];
            int nextCol = c + dir[1];
            if (dfs(nextRow, nextCol, index+1)) {
                return true;
            }
        }
        board[r][c] = temp;
        return false;
    }
}
