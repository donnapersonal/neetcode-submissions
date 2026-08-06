// class Solution {
//     public int jump(int[] nums) {
//         int n = nums.length;
//         int jumps = 0;
//         int curEnd = 0;
//         int maxPos = 0;
//         for (int i = 0; i < n-1; i++) {
//             maxPos = Math.max(maxPos, i + nums[i]);
//             if (i == curEnd) {
//                 jumps++;
//                 curEnd = maxPos;
//                 if (curEnd >= n - 1) break;
//             }
//         }
//         return jumps;
//     }
// }

class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int j = 0;
        for (int i = 1; i < n; i ++) {
            while (j + nums[j] < i) {
                j++;
            }
            dp[i] = dp[j] + 1;
        }
        return dp[n-1];
    }
}
