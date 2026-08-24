// class Solution {
//     private int[] memo;
//     public int climbStairs(int n) {
//         memo = new int[n+1];
//         return dp(n);
//     }

//     private int dp(int n) {
//         if (n <= 2) return n;
//         if (memo[n] > 0) return memo[n];
//         memo[n] = dp(n-1) + dp(n-2);
//         return memo[n];
//     }
// }

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
