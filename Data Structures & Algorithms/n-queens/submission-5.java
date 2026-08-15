class Solution {
    private List<List<String>> res = new ArrayList<>();
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(board, 0);
        return res;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            res.add(solution);
            return;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (!isValue(board, row, col)) {
                continue;
            }
            board[row][col] = 'Q';
            backtrack(board, row+1);
            board[row][col] = '.';
        }
    }

    private boolean isValue(char[][] board, int row, int col) {
        int n = board.length;
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }


        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
}
