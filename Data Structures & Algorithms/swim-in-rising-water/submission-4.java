class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        heap.offer(new int[]{grid[0][0], 0, 0});
        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int time = cur[0];
            int r = cur[1];
            int c = cur[2];
            if (time > dist[r][c]) continue;
            if (r == n-1 && c == n-1) return time;
            for (int[] dir : dirs) {
                int nr = dir[0] + r;
                int nc = dir[1] + c;
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int newTime = Math.max(time, grid[nr][nc]);
                    if (newTime < dist[nr][nc]) {
                        dist[nr][nc] = newTime;
                        heap.offer(new int[]{newTime, nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}
