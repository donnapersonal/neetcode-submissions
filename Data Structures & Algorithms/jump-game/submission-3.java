// class Solution {
//     public boolean canJump(int[] nums) {
//         int maxReachable = 0;
//         int n = nums.length;
//         for (int i = 0; i < n; i ++) {
//             if (i > maxReachable) return false;
//             maxReachable = Math.max(maxReachable, i + nums[i]);
//             if (maxReachable >= n - 1) {
//                 return true;
//             }
//         }
//         return true;
//     }
// }

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i ++) {
            if (i <= dp[i-1]) {
                dp[i] = Math.max(dp[i-1], i + nums[i]);
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1] >= n-1;
    }
}
