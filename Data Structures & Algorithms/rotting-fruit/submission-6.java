class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int minutes = 0;
        Queue<int[]> que = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };
        
        while (!que.isEmpty() && fresh > 0) {
            minutes++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int[] cur = que.poll();
                int x = cur[0];
                int y = cur[1];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (
                        nx >= 0 && nx < m &&
                        ny >= 0 && ny < n &&
                        grid[nx][ny] == 1
                    ) {
                        fresh--;
                        grid[nx][ny] = 2;
                        que.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return fresh == 0 ? minutes : -1;
    }
}
