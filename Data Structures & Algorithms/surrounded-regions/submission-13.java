class Solution {
    private int m;
    private int n;
    private char[][] board;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n-1);
        }

        for (int i = 0; i < n; i++) {
            dfs(0, i);
            dfs(m-1, i);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 'A') {
                    board[r][c] = 'O';
                } else if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c) {
        if (
            r < 0 || r >= m ||
            c < 0 || c >= n ||
            board[r][c] != 'O'
        ) {
            return;
        }

        board[r][c] = 'A';
        dfs(r+1, c);
        dfs(r-1, c);
        dfs(r, c+1);
        dfs(r, c-1);
    }
}
