// class Solution {
//     private List<List<String>> res = new ArrayList<>();
//     private char[][] board;

//     public List<List<String>> solveNQueens(int n) {
//         board = new char[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 board[i][j] = '.';
//             }
//         }
//         backtrack(board, 0);
//         return res;
//     }

//     private void backtrack(char[][] board, int row) {
//         if (row == board.length) {
//             List<String> solution = new ArrayList<>();
//             for (char[] r : board) {
//                 solution.add(new String(r));
//             }
//             res.add(solution);
//             return;
//         }

//         for (int col = 0; col < board[row].length; col++) {
//             if (!isValue(board, row, col)) {
//                 continue;
//             }
//             board[row][col] = 'Q';
//             backtrack(board, row+1);
//             board[row][col] = '.';
//         }
//     }

//     private boolean isValue(char[][] board, int row, int col) {
//         int n = board.length;
//         for (int i = 0; i < row; i++) {
//             if (board[i][col] == 'Q') {
//                 return false;
//             }
//         }


//         for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
//             if (board[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
//             if (board[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         return true;
//     }
// }

class Solution {
    private List<List<String>> res = new ArrayList<>();
    private int[] queens;
    private boolean[] col;
    private boolean[] diag1;
    private boolean[] diag2;

    public List<List<String>> solveNQueens(int n) {
        queens = new int[n];
        col = new boolean[n];
        diag1 = new boolean[n * 2 - 1];
        diag2 = new boolean[n * 2 - 1];

        backtrack(n, 0);
        return res;
    }

    private void backtrack(int n, int row) {
        if (row == n) {
            res.add(buildBoard(queens, n));
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = row + c;
            int d2 = row - c + n -1;
            if (col[c] || diag1[d1] || diag2[d2]) continue;
            queens[row] = c;
            col[c] = diag1[d1] = diag2[d2] = true;
            backtrack(n, row+1);
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
    private List<String> buildBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[r]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
