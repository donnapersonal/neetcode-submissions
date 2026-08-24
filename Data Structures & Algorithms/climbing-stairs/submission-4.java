class Solution {
    private int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        // Arrays.fill(memo, 0);
        return dp(n);
    }

    private int dp(int n) {
        if (n <= 2) return n;
        if (memo[n] > 0) return memo[n];
        memo[n] = dp(n-1) + dp(n-2);
        return memo[n];
    }
}
