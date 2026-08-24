// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
//         int n = cost.length;
//         int[] dp = new int[n+1];
//         for (int i = 2; i < n+1; i++) {
//             dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
//         }
//         return dp[n];
//     }
// }

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev = 0, cur = 0;
        for (int i = 2; i < n+1; i++) {
            int temp = Math.min(cur + cost[i-1], prev + cost[i-2]);
            prev = cur;
            cur = temp;
        }
        return cur;
    }
}
