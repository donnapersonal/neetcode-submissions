// class Solution {
//     private int m;
//     private int n;
//     private int maxArea = 0;
//     int[][] dirs = new int[][] {
//         {1, 0},
//         {-1, 0},
//         {0, 1},
//         {0, -1}
//     };

//     public int maxAreaOfIsland(int[][] grid) {
//         m = grid.length;
//         n = grid[0].length;
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 1) {
//                     Queue<int[]> que = new LinkedList<>();
//                     que.offer(new int[]{i, j});
//                     grid[i][j] = 0;
//                     int area = 1;
//                     while (!que.isEmpty()) {
//                         int[] cur = que.poll();
//                         int curRow = cur[0], curCol = cur[1];
//                         for (int[] dir : dirs) {
//                             int nr = dir[0] + curRow;
//                             int nc = dir[1] + curCol;
//                             if (
//                                 nr >= 0 && nr < m &&
//                                 nc >= 0 && nc < n &&
//                                 grid[nr][nc] == 1
//                             ) {
//                                 grid[nr][nc] = 0;
//                                 que.offer(new int[]{nr, nc});
//                                 area += 1;
//                             }
//                         }
//                     }
//                     maxArea = Math.max(maxArea, area);
//                 }
//             }
//         }
//         return maxArea;
//     }
// }

class Solution {
    private int m;
    private int n;
    private int maxArea = 0;
    int[][] dirs = new int[][] {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                   maxArea = Math.max(maxArea, dfs(grid, i, j)); 
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (
            i < 0 || i >= m ||
            j < 0 || j >= n ||
            grid[i][j] == 0
        ) {
            return 0;
        }

        grid[i][j] = 0;
        int area = 1;
        for (int[] dir : dirs) {
            int dx = dir[0];
            int dy = dir[1];
            area += dfs(grid, dx + i, dy + j);
        }
        return area;
    }
}
