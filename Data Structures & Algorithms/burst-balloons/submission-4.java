class Solution {
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int[] val = new int[m+2];
        val[0] = 1;
        val[m+1] = 1;

        for (int i = 0; i < m; i++) {
            val[i+1] = nums[i];
        }

        int n = val.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len;
                for (int k = left+1; k < right; k++) {
                    int coins = dp[left][k] + val[left] * val[k] * val[right] + dp[k][right];
                    dp[left][right] = Math.max(dp[left][right], coins);
                }
            }
        }

        return dp[0][n-1];
    }
}
