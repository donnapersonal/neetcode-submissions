// class Solution {
//     private int[][] matrix;
//     private int[][] memo;
//     private int m;
//     private int n;
//     private final int[][] dirs = {
//         {-1, 0},
//         {1, 0},
//         {0, -1},
//         {0, 1}
//     };

//     public int longestIncreasingPath(int[][] matrix) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
//         this.matrix = matrix;
//         this.m = matrix.length;
//         this.n = matrix[0].length;
//         this.memo = new int[m][n];
//         int res = 0;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 res = Math.max(res, dfs(i, j));
//             }
//         }
//         return res;
//     }

//     private int dfs(int i, int j) {
//         if (memo[i][j] != 0) {
//             return memo[i][j];
//         }

//         int maxLen = 1;
//         for (int[] dir : dirs) {
//             int nx = i + dir[0];
//             int ny = j + dir[1];
//             if (
//                 nx >= 0 && nx < m &&
//                 ny >= 0 && ny < n &&
//                 matrix[nx][ny] > matrix[i][j]
//             ) {
//                 maxLen = Math.max(maxLen, 1 + dfs(nx, ny));
//             }
//         }
//         memo[i][j] = maxLen;
//         return maxLen;
//     }
// }

class Solution {
    private final int[][] dirs = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] indegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : dirs) {
                    int dx = i + dir[0], dy = j + dir[1];
                    if (
                        dx >= 0 && dx < m
                        && dy >= 0 && dy < n
                        && matrix[dx][dy] > matrix[i][j]
                    ) {
                        indegree[dx][dy]++;
                    }
                } 
            }
        }

        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegree[i][j] == 0) {
                    que.offer(new int[]{i, j});
                }
            }
        }

        int level = 0;
        while (!que.isEmpty()) {
            level++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int x = cur[0], y = cur[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (
                        nx >= 0 && nx < m
                        && ny >= 0 && ny < n
                        && matrix[nx][ny] > matrix[x][y]
                    ) {
                        indegree[nx][ny]--;
                        if (indegree[nx][ny] == 0) {
                            que.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return level;
    }
}
