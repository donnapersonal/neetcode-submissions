class Solution {
    private int m;
    private int n;
    private int[][] heights;
    private int[][] dirs = new int[][]{
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        this.heights = heights;
        this.m = heights.length;
        this.n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];


        for (int r = 0; r < m; r++) {
            dfs(r, 0, pacific, heights[r][0]);
            dfs(r, n - 1, atlantic, heights[r][n - 1]);
        }

        for (int c = 0; c < n; c++) {
            dfs(0, c, pacific, heights[0][c]);
            dfs(m - 1, c, atlantic, heights[m - 1][c]);
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int prevH) {
        if (
            r < 0 || c < 0 ||
            r >= m || c >= n ||
            ocean[r][c] ||
            heights[r][c] < prevH
        ) {
            return;
        }

        ocean[r][c] = true;

        for (int[] dir : dirs) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];

            dfs(nextR, nextC, ocean, heights[r][c]);
        }
    }
}
