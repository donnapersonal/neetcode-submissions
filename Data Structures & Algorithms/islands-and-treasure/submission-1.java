class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return;
        }

        int m = grid.length, n = grid[0].length;
        int INF = 2147483647;
        int CHEST = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == CHEST) {
                    que.offer(new int[]{i, j}); 
                }
            }
        }
        
        int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0], y = cur[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (
                    nx < 0 || nx >= m ||
                    ny < 0 || ny >= n ||
                    grid[nx][ny] != INF
                ) {
                    continue;
                }

                grid[nx][ny] = grid[x][y] + 1;
                que.offer(new int[]{nx, ny});
            }
        }
    }
}
